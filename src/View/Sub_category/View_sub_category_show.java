package View.Sub_category;

import Controller.Sub_category_controller;
import Entity.Sub_category;
import Model.Sub_category_model;
import layout.View_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_sub_category_show extends View_show {

    private Sub_category_model model;
    private Sub_category_controller controller;
    private LinkedList<Sub_category> subcats;
    private Sub_category subcat;

    private JPanel panelId = new JPanel();
    private JPanel panelName = new JPanel();
    private JPanel panelCat = new JPanel();

    private JLabel labelId = new JLabel("Id : ");
    private JLabel labelName = new JLabel("Nom : ");
    private JLabel labelCat = new JLabel("Catégorie : ");

    private JTextField tfId = new JTextField(20);
    private JTextField tfName = new JTextField(20);
    private JTextField tfCat = new JTextField(20);

    public View_sub_category_show(Rectangle bounds) {
        super(bounds);
        model = new Sub_category_model();
        model.addObserver(this);
        controller = new Sub_category_controller(model);
        initCombo();
        subcat = subcats.getFirst();
        updateFields();

        tfId.setEditable(false);
        panelId.add(labelId);
        panelId.add(tfId);
        dataPanel.add(panelId);
        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);
        panelCat.add(labelCat);
        panelCat.add(tfCat);
        dataPanel.add(panelCat);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subcat.setName(tfName.getText());
                subcat.setCategory_id(Integer.valueOf(tfCat.getText()));
                controller.edit(subcat);
                subcat = new Sub_category();
                updateFields();
                initCombo();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.delete(subcat);
                initCombo();
            }
        });
    }

    private void initCombo(){
        comboPanel.removeAll();
        subcats = controller.getAllSubCategories();
        combo = new JComboBox();
        for (Sub_category s : subcats){
            combo.addItem(s);
        }
        comboPanel.add(combo);
        combo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                if (value instanceof Sub_category){
                    setText(((Sub_category) value).getName());
                }
                return this;
            }
        });
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subcat = (Sub_category)combo.getSelectedItem();
                updateFields();
            }
        });

    }

    private void updateFields(){
        tfId.setText(String.valueOf(subcat.getId()));
        tfName.setText(subcat.getName());
        tfCat.setText(String.valueOf(subcat.getCategory_id()));
    }
}
