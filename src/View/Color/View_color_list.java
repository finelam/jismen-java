package View.Color;

import Controller.Color_controller;
import Entity.*;
import Model.Color_model;
import layout.View_list;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_color_list extends View_list {

    private Color_controller controller;
    private Color_model model;
    private LinkedList<Entity.Color> colorList;

    public View_color_list(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Liste des couleurs");
        model = new Color_model();
        controller = new Color_controller(model);
        colorList = controller.getAllColors();

        String[] headers = {"Id", "Nom", "Actions"};
        Object data[][] = new Object[colorList.size()][headers.length];
        int i = 0;
        for (Object obj : colorList){
            Entity.Color col = (Entity.Color) obj;
            data[i][0] = col.getId();
            data[i][1] = col.getName();
            data[i][2] = null;
            i++;
        }

        table = new JTable(data, headers);
        scroll = new JScrollPane(table);
        headerPanel.add(labelHeader);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
    }
}
