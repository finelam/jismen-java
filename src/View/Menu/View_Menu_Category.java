package View.Menu;

import View.Category.View_category_add;
import View.Category.View_category_list;
import View.Category.View_category_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Finelam on 25/01/2016.
 */
public class View_Menu_Category extends JMenu implements ActionListener {
    private JMenuItem itemList    = new JMenuItem("Lister");
    private JMenuItem itemShow      = new JMenuItem("Rechercher");
    private JMenuItem itemAdd       = new JMenuItem("Ajouter");

    public View_Menu_Category() {
        this.setText("Categories");
        this.add(this.itemList);
        this.add(this.itemShow);
        this.add(this.itemAdd);

        this.itemShow.addActionListener(this);
        this.itemList.addActionListener(this);
        this.itemAdd.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Rectangle bounds = this.getRootPane().getContentPane().getBounds();
        JPanel pane = null;
        if (e.getSource() == this.itemAdd){
            pane = new View_category_add(bounds);
        } else if(e.getSource() == this.itemShow){
            pane = new View_category_show(bounds);
        } else if(e.getSource() == this.itemList){
            pane = new View_category_list(bounds);
        }
        this.getRootPane().setContentPane(pane);
    }

    public JMenuItem getItemList() { return itemList; }

    public void setItemList(JMenuItem itemList) {
        this.itemList = itemList;
    }

    public JMenuItem getItemShow() {
        return itemShow;
    }

    public void setItemShow(JMenuItem itemShow) {
        this.itemShow = itemShow;
    }

    public JMenuItem getItemAdd() {
        return itemAdd;
    }

    public void setItemAdd(JMenuItem itemAdd) {
        this.itemAdd = itemAdd;
    }
}
