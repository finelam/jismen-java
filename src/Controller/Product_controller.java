package Controller;

import Entity.Product;
import Model.Product_model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Product_controller {
    private Product_model model;

    public Product_controller(Product_model model){
        this.model = model;
    }

    public LinkedList<Product> getAllProducts(){
        LinkedList<Object> obj =  model.getAll("Product");
        LinkedList<Product> products = new LinkedList<Product>();
        for (Object o : obj){
            products.add((Product)o);
        }
        return products;
    }

    public void edit(Product product){
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("id", product.getId());
        values.put("sub_category_id", product.getSub_category_id());
        values.put("color_id", product.getColor_id());
        values.put("size_id", product.getSize_id());
        values.put("supplier_id", product.getSupplier_id());
        values.put("name", product.getName());
        values.put("priceht", product.getPriceht());
        values.put("pricettc", product.getPricettc());
        values.put("quantity", product.getQuantity());
        values.put("enabled", product.isEnabled() ? 1 : 0);
        values.put("new", product.isNews() ? 1 : 0);
        values.put("promo", product.isPromo() ? 1 : 0);
        values.put("vip", product.isVip() ? 1 : 0);
        values.put("path", product.getPath());
        values.put("description", product.getDescription());
        model.edit("product", values);
    }

    /**
     * Crée en base l'article donné en paramètre
     * @param product
     */
    public void addProduct(Product product){
        HashMap<String, Object> values = new HashMap<>();
        values.put("sub_category_id", product.getSub_category_id());
        values.put("color_id", product.getColor_id());
        values.put("size_id", product.getSize_id());
        values.put("supplier_id", product.getSupplier_id());
        values.put("name", product.getName());
        values.put("priceht", product.getPriceht());
        values.put("pricettc", product.getPricettc());
        values.put("quantity", product.getQuantity());
        values.put("enabled", product.isEnabled() ? 1 : 0);
        values.put("new", product.isNews() ? 1 : 0);
        values.put("promo", product.isPromo() ? 1 : 0);
        values.put("vip", product.isVip() ? 1 : 0);
        values.put("path", product.getPath());
        values.put("description", product.getDescription());
        model.add("product", values);
    }

    public void delete(Product product){
        model.delete("product", product.getId());
    }
}
