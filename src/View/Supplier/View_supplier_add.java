package View.Supplier;

import Controller.Supplier_controller;
import Entity.Supplier;
import Model.Supplier_model;
import layout.View_add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_supplier_add extends View_add {

    private Supplier_model model = new Supplier_model();
    private Supplier_controller controller = new Supplier_controller(model);

    private JPanel panelName= new JPanel();
    private JPanel panelAddress= new JPanel();
    private JPanel panelPC= new JPanel();
    private JPanel panelCity= new JPanel();
    private JPanel panelContract= new JPanel();

    private JLabel labelName = new JLabel("Nom : ");
    private JLabel labelAddress = new JLabel("Adresse : ");
    private JLabel labelPC = new JLabel("Code postal : ");
    private JLabel labelCity = new JLabel("Ville : ");
    private JLabel labelContract = new JLabel("Contrat : ");
    private JTextField tfName = new JTextField(20);
    private JTextField tfAdress = new JTextField(20);
    private JTextField tfPC = new JTextField(20);
    private JTextField tfCity = new JTextField(20);
    private JTextField tfContract = new JTextField(20);

    public View_supplier_add(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Nouveau fournisseur");
        model.addObserver(this);

        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);
        panelAddress.add(labelAddress);
        panelAddress.add(tfAdress);
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

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Supplier supplier = new Supplier();
                supplier.setName(tfName.getText());
                supplier.setAddress(tfAdress.getText());
                supplier.setPostal_code(tfPC.getText());
                supplier.setCity(tfCity.getText());
                supplier.setContract(tfContract.getText());
                controller.addSupplier(supplier);
            }
        });
    }
}
