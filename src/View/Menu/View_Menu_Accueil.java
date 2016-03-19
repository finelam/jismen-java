package View.Menu;

import View.Category.View_category_list;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Finelam on 25/01/2016.
 */
public class View_Menu_Accueil extends JMenu {

    private JMenuItem itemDisconnect = new JMenuItem("Déconnecter");
    private JMenuItem itemQuitter = new JMenuItem("Quitter");

    public View_Menu_Accueil(){
        this.setMnemonic(KeyEvent.VK_A);
        this.setText("Accueil");
        itemDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setBounds(getRootPane().getContentPane().getBounds());
                getRootPane().setContentPane(panel);
            }
        });
        itemQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(this.itemDisconnect);
        this.add(this.itemQuitter);
        this.setVisible(true);
    }

    public JMenuItem getItemFichier() { return itemDisconnect; }

    public void setItemFichier(JMenuItem itemFichier) {
        this.itemDisconnect = itemFichier;
    }

    public JMenuItem getItemQuitter() {
        return itemQuitter;
    }

    public void setItemQuitter(JMenuItem itemQuitter) {
        this.itemQuitter = itemQuitter;
    }
}
