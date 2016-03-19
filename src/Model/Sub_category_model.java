package Model;

import Controller.Db_controller;
import Entity.Sub_category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Observable;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Sub_category_model extends Model{

    private Db_controller db;
    private LinkedList<Sub_category> sub_categories;

    public Sub_category_model(){
        db = new Db_controller();
    }

    public LinkedList<Sub_category> getAllSubCategories(){
        sub_categories = new LinkedList<Sub_category>();
        String query = "SELECT * FROM sub_category";

        db.connect();
        try {
            Statement stat = db.getConnexion().createStatement();
            ResultSet res = stat.executeQuery(query);
            while (res.next()){
                int id = res.getInt("id");
                int cat = res.getInt("category_id");
                String name = res.getString("name");
                boolean enabled = res.getBoolean("enabled");
                Sub_category subcat = new Sub_category(id, cat, name, enabled);
                sub_categories.add(subcat);
            }
            stat.close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return sub_categories;
    }
}
