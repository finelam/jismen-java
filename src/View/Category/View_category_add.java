package View.Category;

import Controller.Category_controller;
import Entity.Category;
import Model.Category_model;
import layout.View_add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_category_add extends View_add {
    private Category_model model            = new Category_model();
    private Category_controller controller  = new Category_controller(model);

    private JPanel panelName = new JPanel();
    private JPanel panelEnabled = new JPanel();

    private JLabel labelName    = new JLabel("Nom : ");
    private JLabel labelEnabled = new JLabel("Afficher");
    private JTextField tfName   = new JTextField(20);
    private JCheckBox cbEnabled = new JCheckBox();

    public View_category_add(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Nouvelle catégorie");
        model.addObserver(this);

        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);
        panelEnabled.add(labelEnabled);
        panelEnabled.add(cbEnabled);
        dataPanel.add(panelEnabled);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Category cat = new Category();
                cat.setName(tfName.getText());
                cat.setEnabled(cbEnabled.isSelected());
                controller.addCategory(cat);
            }
        });
    }
}
