package View.Size;

import Controller.Size_controller;
import Entity.Size;
import Model.Size_model;
import layout.View_add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_size_add extends View_add{
    private Size_model model = new Size_model();
    private Size_controller controller = new Size_controller(model);
    private Size size = new Size();

    private JPanel panelName = new JPanel();
    private JLabel labelName = new JLabel("Nom : ");
    private JTextField tfName = new JTextField(20);

    public View_size_add(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Nouvelle taille");
        model.addObserver(this);

        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size.setName(tfName.getText());
                controller.addSize(size);
            }
        });
        buttonPanel.add(btnAdd);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
