package View.Supplier;

import Controller.Supplier_controller;
import Entity.Supplier;
import Model.Supplier_model;
import layout.View_list;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_supplier_list extends View_list {
    private LinkedList<Supplier> suppliers;
    private JTable table;
    private JScrollPane scroll;
    private Supplier_model model;
    private Supplier_controller controller;

    public View_supplier_list(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Liste des fournisseurs");
        model = new Supplier_model();
        controller = new Supplier_controller(model);
        suppliers = controller.getAllSuppliers();
        String headers[] = {"Id", "Nom", "Adresse", "Code postal", "Ville", "Actions"};
        Object data[][] = new Object[suppliers.size()][headers.length];
        int i = 0;
        for (Object o : suppliers){
            Supplier s = (Supplier) o;
            data[i][0]  = s.getId();
            data[i][1]  = s.getName();
            data[i][2]  = s.getAddress();
            data[i][3]  = s.getPostal_code();
            data[i][4]  = s.getCity();
            data[i][5]  = null;
            i++;
        }
        table = new JTable(data, headers);
        scroll = new JScrollPane(table);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
    }
}
