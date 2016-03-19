package View.TVA;

import Controller.TVA_controller;
import Entity.TVA;
import Model.TVA_model;
import layout.View_add;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_tva_add extends View_add{
    private TVA_model model = new TVA_model();
    private TVA_controller controller = new TVA_controller(model);

    private JPanel panelRate = new JPanel();
    private JLabel labelRate = new JLabel("Taux");
    private JTextField tfRate = new JTextField(20);

    public View_tva_add(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Nouveau taux de TVA");
        model.addObserver(this);
        panelRate.add(labelRate);
        panelRate.add(tfRate);
        dataPanel.add(panelRate);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TVA tva = new TVA();
                tva.setRate(Double.valueOf(tfRate.getText()));
                controller.addTva(tva);
            }
        });
    }
}
