package View.Sub_category;

import Controller.Sub_category_controller;
import Entity.Sub_category;
import Model.Sub_category_model;
import layout.View_add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_sub_category_add extends View_add {
    private Sub_category_model model = new Sub_category_model();
    private Sub_category_controller controller = new Sub_category_controller(model);

    private JPanel panelName = new JPanel();
    private JPanel panelCategory = new JPanel();
    private JPanel panelEnabled = new JPanel();
    private JLabel labelName = new JLabel("Nom : ");
    private JLabel labelCategory = new JLabel("Catégorie : ");
    private JLabel labelEnabled = new JLabel("Afficher : ");
    private JTextField tfName = new JTextField(20);
    private JTextField tfCategory = new JTextField(20);
    private JCheckBox cbEnabled = new JCheckBox();

    public View_sub_category_add(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Nouvelle sous-catégorie");
        model.addObserver(this);

        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);
        panelCategory.add(labelCategory);
        panelCategory.add(tfCategory);
        dataPanel.add(panelCategory);
        panelEnabled.add(labelEnabled);
        panelEnabled.add(cbEnabled);
        dataPanel.add(panelEnabled);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sub_category sub_category = new Sub_category();
                sub_category.setName(tfName.getText());
                sub_category.setCategory_id(Integer.valueOf(tfCategory.getText()));
                sub_category.setEnabled(cbEnabled.isSelected());
                controller.addSubCategory(sub_category);
            }
        });
    }
}
