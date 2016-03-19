package View.Menu;

import View.Supplier.View_supplier_add;
import View.Supplier.View_supplier_list;
import View.Supplier.View_supplier_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Finelam on 25/01/2016.
 */
public class View_Menu_Supplier extends JMenu implements ActionListener {
    private JMenuItem itemList    = new JMenuItem("Lister");
    private JMenuItem itemSearch    = new JMenuItem("Rechercher");
    private JMenuItem itemAdd       = new JMenuItem("Ajouter");

    public View_Menu_Supplier(){
        this.setText("Fournisseurs");
        this.add(this.itemList);
        this.itemList.addActionListener(this);
        this.add(this.itemSearch);
        this.itemSearch.addActionListener(this);
        this.add(this.itemAdd);
        this.itemAdd.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Rectangle bounds = this.getRootPane().getContentPane().getBounds();
        JPanel pane = null;

        if(e.getSource() == this.itemList){
            pane = new View_supplier_list(bounds);
        }else if(e.getSource() == this.itemSearch){
            pane = new View_supplier_show(bounds);
        }else if(e.getSource() == this.itemAdd){
            pane = new View_supplier_add(bounds);
        }

        this.getRootPane().setContentPane(pane);
    }

    public JMenuItem getItemList() { return itemList; }

    public void setItemList(JMenuItem itemList) {
        this.itemList = itemList;
    }

    public JMenuItem getItemSearch() {
        return itemSearch;
    }

    public void setItemSearch(JMenuItem itemSearch) {
        this.itemSearch = itemSearch;
    }

    public JMenuItem getItemAdd() {
        return itemAdd;
    }

    public void setItemAdd(JMenuItem itemAdd) {
        this.itemAdd = itemAdd;
    }
}
