package View.Sub_category;

import Controller.Db_controller;
import Controller.Sub_category_controller;
import Entity.Sub_category;
import Model.Sub_category_model;
import layout.View_list;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_sub_category_list extends View_list {

    private Sub_category_model model;
    private Sub_category_controller controller;
    private LinkedList<Sub_category> sub_categories;

    public View_sub_category_list(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Liste des sous-catégories");
        model            = new Sub_category_model();
        controller       = new Sub_category_controller(model);
        sub_categories   = controller.getAllSubCategories();
        String[] headers = {"Id", "Nom", "Afficher", "Catégorie", "Actions"};
        Object data[][]  = new Object[sub_categories.size()][headers.length];

        int i = 0;
        for (Object o : sub_categories){
            Sub_category s  = (Sub_category) o;
            data[i][0]      = s.getId();
            data[i][1]      = s.getName();
            data[i][2]      = s.isEnabled() ? "Oui" : "Non";
            data[i][3]      = s.getCategory_id();
            data[i][4]      = null;
            i++;
        }

        table = new JTable(data, headers);
        scroll = new JScrollPane(table);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
    }
}
