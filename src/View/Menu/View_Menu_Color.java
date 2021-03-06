package View.Menu;

import View.Color.View_color_add;
import View.Color.View_color_list;
import View.Color.View_color_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Finelam on 25/01/2016.
 */
public class View_Menu_Color extends JMenu implements ActionListener{
    private JMenuItem itemList    = new JMenuItem("Lister");
    private JMenuItem itemSearch    = new JMenuItem("Rechercher");
    private JMenuItem itemAdd       = new JMenuItem("Ajouter");

    public View_Menu_Color(){
        this.setText("Couleurs");
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
            pane = new View_color_list(bounds);
        } else if(e.getSource() == this.itemSearch){
            pane = new View_color_show(bounds);
        }else if(e.getSource() == this.itemAdd){
            pane = new View_color_add(bounds);
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
