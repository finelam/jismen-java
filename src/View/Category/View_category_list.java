package View.Category;

import Controller.Category_controller;
import Entity.Category;
import Model.Category_model;
import layout.View_list;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_category_list extends View_list {

    private Category_controller controller;
    private Category_model model;
    private LinkedList<Category> categoryList;

    public View_category_list(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Liste des catégories");
        model           = new Category_model();
        controller      = new Category_controller(model);
        categoryList    = controller.getAllCategories();

        String[] headers = {"Id", "Nom", "Afficher", "Actions"};
        Object data[][] = new Object[categoryList.size()][headers.length];
        int i = 0;
        for (Category cat : categoryList){
            data[i][0] = cat.getId();
            data[i][1] = cat.getName();
            data[i][2] = cat.isEnabled();
            data[i][3] = null;
            i++;
        }

        this.setLayout(new BorderLayout());
        this.setBounds(bounds);
        table = new JTable(data, headers);
        JScrollPane scroll = new JScrollPane(this.table);
        scroll.setVisible(true);
        headerPanel.add(labelHeader);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
    }
}
