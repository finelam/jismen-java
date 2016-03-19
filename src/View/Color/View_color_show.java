package View.Color;

import Controller.Color_controller;
import Entity.*;
import Model.Color_model;
import javafx.scene.control.ComboBox;
import layout.View_show;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_color_show extends View_show {
    JPanel panelId = new JPanel();
    JPanel panelName = new JPanel();

    JLabel labelId = new JLabel("Id : ");
    JLabel labelName = new JLabel("Nom : ");

    JTextField tfId = new JTextField(20);
    JTextField tfName = new JTextField(20);

    private Color_model model;
    private Color_controller controller;
    private LinkedList<Entity.Color> colors;
    private Entity.Color col;

    public View_color_show(Rectangle bounds) {
        super(bounds);
        model = new Color_model();
        model.addObserver(this);
        controller = new Color_controller(model);
        colors = controller.getAllColors();
        col = colors.getFirst();
        updateFields();
        initCombo();

        tfId.setEditable(false);
        panelId.add(labelId);
        panelId.add(tfId);
        dataPanel.add(panelId);
        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col.setName(tfName.getText());
                controller.edit(col);
                initCombo();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.delete(col);
                col = new Entity.Color();
                updateFields();
                initCombo();
            }
        });
    }

    private void initCombo(){
        comboPanel.removeAll();
        combo = new JComboBox();
        comboPanel.add(combo);
        for (Entity.Color c : colors){
            combo.addItem(c);
        }
        combo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Entity.Color){
                    Entity.Color col = (Entity.Color) value;
                    setText(col.getName());
                }
                return this;
            }
        });
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = (Entity.Color)combo.getSelectedItem();
                updateFields();
            }
        });
    }

    private void updateFields(){
        tfId.setText(String.valueOf(col.getId()));
        tfName.setText(col.getName());
    }
}
