package View.TVA;

import Controller.TVA_controller;
import Entity.TVA;
import Model.TVA_model;
import layout.View_list;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_tva_list extends View_list {

    private LinkedList<TVA> allTva;
    private TVA_model model;
    private TVA_controller controller;

    public View_tva_list(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Liste des taux de TVA");
        this.setLayout(new BorderLayout());
        model               = new TVA_model();
        controller          = new TVA_controller(model);
        allTva              = controller.getAllTva();
        String headers[]    = {"Id", "Taux", "Actions"};
        Object data[][]     = new Object[allTva.size()][headers.length];
        int i               = 0;
        for (Object o : allTva){
            TVA t = (TVA) o;
            data[i][0] = t.getId();
            data[i][1] = t.getRate();
            data[i][2] = null;
            i++;
        }
        table = new JTable(data, headers);
        scroll = new JScrollPane(table);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
    }
}
