package View.Supplier;

import Controller.Supplier_controller;
import Entity.Supplier;
import Model.Supplier_model;
import layout.View_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_supplier_show extends View_show {

    private Supplier_model model;
    private Supplier_controller controller;
    private LinkedList<Supplier> suppliers;
    private Supplier supplier;

    private JPanel panelId = new JPanel();
    private JPanel panelName = new JPanel();
    private JPanel panelAddress = new JPanel();
    private JPanel panelPC = new JPanel();
    private JPanel panelCity = new JPanel();
    private JPanel panelContract = new JPanel();

    private JLabel labelId = new JLabel("Id : ");
    private JLabel labelName = new JLabel("Nom : ");
    private JLabel labelAddress = new JLabel("Adresse : ");
    private JLabel labelPC = new JLabel("Code Postal : ");
    private JLabel labelCity = new JLabel("Ville : ");
    private JLabel labelContract = new JLabel("N° de contrat : ");

    private JTextField tfId = new JTextField(20);
    private JTextField tfName = new JTextField(20);
    private JTextField tfAddress = new JTextField(20);
    private JTextField tfPC = new JTextField(20);
    private JTextField tfCity = new JTextField(20);
    private JTextField tfContract = new JTextField(20);


    public View_supplier_show(Rectangle bounds) {
        super(bounds);
        model = new Supplier_model();
        model.addObserver(this);
        controller = new Supplier_controller(model);
        initCombo();
        supplier = suppliers.getFirst();
        updateFields();

        tfId.setEditable(false);
        panelId.add(labelId);
        panelId.add(tfId);
        dataPanel.add(panelId);
        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);
        panelAddress.add(labelAddress);
        panelAddress.add(tfAddress);
        dataPanel.add(panelAddress);
        panelPC.add(labelPC);
        panelPC.add(tfPC);
        dataPanel.add(panelPC);
        panelCity.add(labelCity);
        panelCity.add(tfCity);
        dataPanel.add(panelCity);
        panelContract.add(labelContract);
        panelContract.add(tfContract);
        dataPanel.add(panelContract);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supplier.setName(tfName.getText());
                supplier.setAddress(tfAddress.getText());
                supplier.setPostal_code(tfPC.getText());
                supplier.setCity(tfCity.getText());
                supplier.setContract(tfContract.getText());
                controller.edit(supplier);
                initCombo();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.delete(supplier);
                supplier = new Supplier();
                updateFields();
                initCombo();
            }
        });
    }

    public void initCombo(){
        comboPanel.removeAll();
        suppliers = controller.getAllSuppliers();
        combo = new JComboBox();
        for (Supplier s : suppliers){
            combo.addItem(s);
        }
        comboPanel.add(combo);
        combo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Supplier){
                    Supplier s = (Supplier) value;
                    setText(s.getName());
                }
                return this;
            }
        });
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supplier = (Supplier)combo.getSelectedItem();
                updateFields();
            }
        });
    }

    public void updateFields(){
        tfId.setText(String.valueOf(supplier.getId()));
        tfName.setText(supplier.getName());
        tfAddress.setText(supplier.getAddress());
        tfPC.setText(supplier.getPostal_code());
        tfCity.setText(supplier.getCity());
        tfContract.setText(supplier.getContract());
    }
}
