package Model;

import Controller.Db_controller;
import Entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Observable;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Product_model extends Model {
    public LinkedList<Product> getAllProducts(){
        LinkedList<Product> products = new LinkedList<Product>();
        Db_controller db = new Db_controller();
        String query = "SELECT * FROM product;";

        db.connect();
        try {
            Statement stat = db.getConnexion().createStatement();
            ResultSet res = stat.executeQuery(query);
            while (res.next()){
                int id = res.getInt("id");
                int subcat = res.getInt("sub_category_id");
                int tva = res.getInt("tva_id");
                int color = res.getInt("color_id");
                int size = res.getInt("size_id");
                int supplier = res.getInt("supplier_id");
                String name = res.getString("name");
                double priceht = res.getDouble("priceht");
                double pricettc = res.getDouble("pricettc");
                int quantity = res.getInt("quantity");
                boolean enabled = res.getBoolean("enabled");
                boolean news = res.getBoolean("new");
                boolean promo = res.getBoolean("promo");
                boolean vip = res.getBoolean("vip");
                String path = res.getString("path");
                String description = res.getString("description");
                Product prod = new Product(id, subcat, tva, color, size, supplier, name, priceht, pricettc, quantity, enabled, news, promo, vip, path, description);
                products.add(prod);
            }
            stat.close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return products;
    }
}
