package View.TVA;

import Controller.TVA_controller;
import Entity.TVA;
import Model.TVA_model;
import layout.View_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_tva_show extends View_show {

    private TVA_model model;
    private TVA_controller controller;
    private LinkedList<TVA> tvas;
    private TVA tva;

    private JPanel panelId = new JPanel();
    private JPanel panelRate = new JPanel();

    private JLabel labelId = new JLabel("Id : ");
    private JLabel labelRate = new JLabel("Taux : ");

    private JTextField tfId = new JTextField(20);
    private JTextField tfRate = new JTextField(20);

    public View_tva_show(Rectangle bounds) {
        super(bounds);
        model = new TVA_model();
        model.addObserver(this);
        controller = new TVA_controller(model);
        initCombo();
        tva = tvas.getFirst();
        updateFields();

        tfId.setEditable(false);
        panelId.add(labelId);
        panelId.add(tfId);
        dataPanel.add(panelId);
        panelRate.add(labelRate);
        panelRate.add(tfRate);
        dataPanel.add(panelRate);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tva.setRate(Double.valueOf(tfRate.getText()));
                controller.edit(tva);
                initCombo();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.delete(tva);
                tva = new TVA();
                updateFields();
                initCombo();
            }
        });
    }

    private void initCombo(){
        comboPanel.removeAll();
        tvas = controller.getAllTva();
        combo = new JComboBox();
        for (TVA t : tvas){
            combo.addItem(t);
        }
        comboPanel.add(combo);
        combo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof TVA){
                    TVA t = (TVA) value;
                    setText(String.valueOf(t.getRate()));
                }
                return this;
            }
        });
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tva = (TVA)combo.getSelectedItem();
                updateFields();
            }
        });
    }

    private void updateFields(){
        tfId.setText(String.valueOf(tva.getId()));
        tfRate.setText(String.valueOf(tva.getRate()));
    }
}
