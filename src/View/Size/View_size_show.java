package View.Size;

import Controller.Size_controller;
import Entity.Size;
import Model.Size_model;
import layout.View_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.NavigableMap;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_size_show extends View_show {

    private Size_model model;
    private Size_controller controller;
    private LinkedList<Size> sizes;
    private Size size;

    private JPanel panelId = new JPanel();
    private JPanel panelName = new JPanel();

    private JLabel labelId = new JLabel("Id : ");
    private JLabel labelName = new JLabel("Nom : ");

    private JTextField tfId = new JTextField(20);
    private JTextField tfName = new JTextField(20);

    public View_size_show(Rectangle bounds) {
        super(bounds);
        model = new Size_model();
        model.addObserver(this);
        controller = new Size_controller(model);
        initCombo();
        size = sizes.getFirst();
        updateFields();

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
                size.setName(tfName.getText());
                controller.edit(size);
                initCombo();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.delete(size);
                size = new Size();
                updateFields();
                initCombo();
            }
        });
    }

    private void initCombo(){
        comboPanel.removeAll();
        sizes = controller.getAllSizes();
        combo = new JComboBox();
        for (Size s : sizes){
            combo.addItem(s);
        }
        comboPanel.add(combo);
        combo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                if (value instanceof Size){
                    Size s = (Size)value;
                    setText(s.getName());
                }
                return this;
            }
        });
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = (Size)combo.getSelectedItem();
                updateFields();
            }
        });
    }

    public void updateFields(){
        tfId.setText(String.valueOf(size.getId()));
        tfName.setText(size.getName());
    }
}
