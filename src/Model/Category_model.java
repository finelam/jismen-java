package Model;

import Controller.Db_controller;
import Entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Category_model extends Model {
    private Db_controller db = new Db_controller();

    /**
     * Retourne la liste des catégories
     * @return LinkedList<Category>
     */
    public LinkedList<Category> getAllCategories(){
        LinkedList<Category> categoryList = new LinkedList<Category>();
        String query = "SELECT * FROM category";
        db.connect();
        try {
            java.sql.Statement stat = db.getConnexion().createStatement();
            ResultSet res = stat.executeQuery(query);
            while (res.next()){
                int id          = res.getInt("id");
                String name     = res.getString("name");
                boolean enabled = res.getBoolean("enabled");
                Category cat    = new Category(id, name, enabled);
                categoryList.add(cat);
            }
            stat.close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return categoryList;
    }
}
