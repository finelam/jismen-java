package View.Color;

import Controller.Color_controller;
import Entity.Color;
import Model.Color_model;
import layout.View_add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_color_add extends View_add{
    private Color_model model = new Color_model();
    private Color_controller controller = new Color_controller(model);

    private JPanel panelName = new JPanel();
    private JLabel labelName = new JLabel("Nom : ");
    private JTextField tfName = new JTextField(20);

    public View_color_add(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Nouvelle couleur");
        model.addObserver(this);
        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color col = new Color();
                col.setName(tfName.getText());
                controller.addColor(col);
            }
        });
    }
}
