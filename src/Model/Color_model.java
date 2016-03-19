package Model;

import Controller.Db_controller;
import Entity.Category;
import Entity.Color;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Color_model extends Model {
    private Db_controller db = new Db_controller();

    /**
     * Retourne toutes les couleurs en BdD
     * @return LinkedList<Color>
     */
    public LinkedList<Color> getAllColors(){
        LinkedList<Color> colorList = new LinkedList<Color>();
        String query = "SELECT * FROM color";
        db.connect();
        try {
            java.sql.Statement stat = db.getConnexion().createStatement();
            ResultSet res = stat.executeQuery(query);
            while (res.next()){
                int id          = res.getInt("id");
                String name     = res.getString("name");
                Color color     = new Color(id, name);
                colorList.add(color);
            }
            stat.close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return colorList;
    }
}
