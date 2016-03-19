package View.Category;

import Controller.Category_controller;
import Entity.Category;
import Model.Category_model;
import layout.View_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_category_show extends View_show {

    private Category_model model;
    private Category_controller controller;
    private LinkedList<Category> categories;
    private Category cat;

    private JPanel panelId      = new JPanel();
    private JPanel panelName    = new JPanel();
    private JPanel panelEnabled = new JPanel();

    private JLabel labelId      = new JLabel("Id : ");
    private JLabel labelName    = new JLabel("Nom : ");
    private JLabel labelEnabled = new JLabel("Afficher : ");

    private JTextField tfId     = new JTextField(20);
    private JTextField tfName   = new JTextField(20);
    private JCheckBox cbEnable  = new JCheckBox();

    public View_category_show(Rectangle bounds) {
        super(bounds);
        model = new Category_model();
        model.addObserver(this);
        controller = new Category_controller(model);
        initCombo();
        cat = categories.getFirst();
        updateFields();

        tfId.setEditable(false);
        panelId.add(labelId);
        panelId.add(tfId);
        dataPanel.add(panelId);
        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);
        panelEnabled.add(labelEnabled);
        panelEnabled.add(cbEnable);
        dataPanel.add(panelEnabled);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat.setName(tfName.getText());
                cat.setEnabled(cbEnable.isSelected());
                controller.edit(cat);
                initCombo();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.delete(cat);
                cat = new Category();
                updateFields();
                initCombo();
            }
        });
    }

    public void updateFields(){
        tfId.setText(String.valueOf(cat.getId()));
        tfName.setText(cat.getName());
        cbEnable.setSelected(cat.isEnabled());
    }

    public void initCombo(){
        comboPanel.removeAll();
        categories = controller.getAllCategories();
        combo = new JComboBox();
        comboPanel.add(combo);
        for (Category cat : categories) {
            combo.addItem(cat);
        }
        combo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Category){
                    Category cat = (Category) value;
                    setText(cat.getName());
                }
                return this;
            }

        });
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat = (Category)combo.getSelectedItem();
                updateFields();
            }
        });
    }
}
