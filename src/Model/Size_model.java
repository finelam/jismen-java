package Model;

import Controller.Db_controller;
import Entity.Size;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Observable;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Size_model extends Model{
    private Db_controller db;
    private LinkedList<Size> sizes;

    public Size_model(){
        this.db = new Db_controller();
        this.sizes = new LinkedList<Size>();
    }

    public LinkedList<Size> getAllSizes(){
        db.connect();
        String query = "SELECT * FROM size;";
        try {
            Statement stat = db.getConnexion().createStatement();
            ResultSet res = stat.executeQuery(query);
            while (res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                Size size = new Size(id, name);
                sizes.add(size);
            }
            stat.close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return sizes;
    }


}
