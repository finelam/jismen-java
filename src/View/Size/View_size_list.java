package View.Size;

import Controller.Size_controller;
import Entity.Size;
import Model.Size_model;
import layout.View_list;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_size_list extends View_list {

    private Size_model model;
    private Size_controller controller;

    public View_size_list(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Liste des tailles");
        model = new Size_model();
        controller = new Size_controller(model);
        LinkedList<Size> sizes = controller.getAllSizes();
        String[] headers = {"Id", "Nom", "Actions"};
        Object[][] data = new Object[sizes.size()][headers.length];
        int i = 0;
        for (Object o : sizes){
            Size s = (Size) o;
            data[i][0] = s.getId();
            data[i][1] = s.getName();
            i++;
        }
        table = new JTable(data, headers);
        scroll = new JScrollPane(table);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
