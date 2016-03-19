package Model;

import Controller.Db_controller;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.ObjectType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

/**
 * Created by Finelam on 20/02/2016.
 */
public class Model extends Observable {

    protected Db_controller db = new Db_controller();

    /**
     * Renvoie une LinkedList<Object> contenant toutes les entrées de la table <code>table</code>
     * @param name
     * @return
     */
    public LinkedList<Object> getAll(String name){
        Class cl = new Object().getClass();
        LinkedList<Object> all = new LinkedList<Object>();

        try {
            cl = Class.forName("Entity." + name);

            String class_name = cl.getSimpleName().toLowerCase();
            String query = "SELECT * FROM " + class_name + ";";

            db.connect();
            try {
                Statement stat = db.getConnexion().createStatement();
                ResultSet res = stat.executeQuery(query);
                ResultSetMetaData rsmd = res.getMetaData();
                List<String> colNames = new ArrayList<String>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++){
                    colNames.add(rsmd.getColumnName(i));
                }

                int rowIndex = 0;
                while (res.next()){
//                    System.out.println("row : " + rowIndex);
                    Object entity = cl.newInstance();
                    rowIndex++;
                    List<Object> rowData = new LinkedList<Object>();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++){
                        rowData.add(res.getObject(i));
                    }
                    for (int colIndex = 0; colIndex < rsmd.getColumnCount(); colIndex++){
                        Object colObject    = rowData.get(colIndex);
//                        Class objClass = colObject.getClass();
                        String colName = colNames.get(colIndex);
                        String methodName = "set" + colName.substring(0, 1).toUpperCase() + colName.substring(1);
//                        System.out.println(methodName + " ( " + colObject + " )");
                        Method method = entity.getClass().getMethod(methodName, new Object().getClass());
                        method.invoke(entity, colObject);
                    }
                    all.add(entity);
                }
                res.close();
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            db.disconnect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return all;
    }

    /**
     * Renvoie l'entité <code>id</code> de la table <code>table</code>
     * @param table
     * @param id
     * @return
     */
    public Object find(String table, int id){
        Object result = null;
        Class cl = null;
        String query = "SELECT * FROM " + table.toLowerCase() + " WHERE id = " + id + ";";
        db.connect();
        try {
            cl = Class.forName("Entity." + table);
            Statement stat = db.getConnexion().createStatement();
            ResultSet res = stat.executeQuery(query);
            ResultSetMetaData rsmd = res.getMetaData();
            List<String> colNames = new ArrayList<String>();
            List<Object> data = new LinkedList<Object>();
            int colCount = rsmd.getColumnCount();
            if (res.next()){
                for (int i = 1; i <= colCount; i++){
                    colNames.add(rsmd.getColumnName(i));
                    data.add(res.getObject(i));
                }
                result = cl.newInstance();
                for (int i = 0; i < colCount; i++){
                    Object value = data.get(i);
                    String colName = colNames.get(i);
                    String methodName = colName.substring(0,1).toUpperCase() + colName.substring(1);
                    Method method = result.getClass().getMethod("set" + methodName, value.getClass());
                    method.invoke(result, value);
                }
            }
            res.close();
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        db.disconnect();
        notifyObservers(result);

        return result;
    }

    /**
     * Met à jour l'entité <code>id</code> de la table <code>table</code>
     * @param table
     * @param values
     */
    public void edit(String table, HashMap<String, Object> values){
        String query = "UPDATE " + table + " SET ";
        Iterator it = values.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            String key = (String) pair.getKey();
            Object value = pair.getValue();
            query += key + " = '" + (value == null || value.equals("null") ? null : value) + "'";
            if (it.hasNext()) {
                query += ", ";
            }
        }
        query += " WHERE id = " + values.get("id") + ";";

        boolean success = executeQuery(query);

        this.setChanged();
        notifyObservers(success);
    }

    /**
     * Supprime l'entité avec l'id <code>id</code> de la table <code>table</code>
     * @param table
     * @param id
     */
    public void delete(String table, int id){
        String query = "DELETE FROM " + table + " WHERE id = ?;";
        PreparedStatement pstat = null;
        setChanged();
        boolean success = false;
        try{
            db.connect();
            Connection con = db.getConnexion();
            pstat = con.prepareStatement(query);
            pstat.setObject(1, id);
            pstat.execute();
            success = true;
            pstat.close();
            db.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }
        notifyObservers(success);
    }

    /**
     * Exécute la requete passée en paramètre
     * @param query
     */
    private boolean executeQuery(String query){
        boolean success = false;
        db.connect();
        try {
            Statement stat = db.getConnexion().createStatement();
            stat.execute(query);
            stat.close();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }
        db.disconnect();
        return success;
    }

    /**
     * Enregistre dans la table <code>table</code> les données de <code>values</code>
     * @param table
     * @param values
     */
    public void add(String table, HashMap<String, Object> values){
        PreparedStatement pstat = null;
        boolean success = false;

        String query = "INSERT INTO " + table + " (";
        Iterator it = values.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            String key = (String) pair.getKey();
            query += key;
            if (it.hasNext()){
                query += ", ";
            }
        }
        query += ") VALUES (";
        it = values.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            query += "?";
            if (it.hasNext()){
                query += ", ";
            } else {
                query += ");";
            }
        }

        int i = 1;
        try {
            db.connect();
            Connection con = db.getConnexion();
            pstat = con.prepareStatement(query);
            it = values.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry pair = (Map.Entry) it.next();
                Object value = (Object) pair.getValue();
                pstat.setObject(i, value);
                i++;
            }
            pstat.execute();
            success = true;
            pstat.close();
            db.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            success  = false;
        }

        this.setChanged();
        notifyObservers(success);
    }

    public void login(String login, String pass){
        Object success ;
        if (login.equals("a"))
            success = true;
        else
            success = null;
        setChanged();
        notifyObservers(success);
    }
}
