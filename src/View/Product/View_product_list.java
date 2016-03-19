package View.Product;

import Controller.Command_controller;
import Controller.Product_controller;
import Entity.Product;
import Model.Command_model;
import Model.Product_model;
import layout.View_list;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_product_list extends View_list {

    private Product_model model;
    private Product_controller controller;
    private LinkedList<Product> products;
    private JTable table;

    public View_product_list(Rectangle bounds) {
        super(bounds);
        model       = new Product_model();
        controller  = new Product_controller(model);
        products    = controller.getAllProducts();

        String[] headers    = {"Id", "Nom", "Prix HT", "Fournisseur", "Quantité", "Actions"};
        Object data[][]     = new Object[products.size()][headers.length];
        int i= 0;
        for (Object obj : products){
            Product prod = (Product) obj;
            data[i][0] = prod.getId();
            data[i][1] = prod.getName();
            data[i][2] = prod.getPriceht();
            data[i][3] = prod.getSupplier_id();
            data[i][4] = prod.getQuantity();
            data[i][5] = "";
            i++;
        }

        table = new JTable(data, headers);
        scroll = new JScrollPane(table);
        this.setLayout(new BorderLayout());
        labelHeader.setText("Liste des articles");
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
    }
}
