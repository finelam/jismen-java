package View;

import Controller.Db_controller;
import Model.Model;
import View.Menu.Main_menu_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Finelam on 20/01/2016.
 */
public class Main_view extends JFrame implements Observer {

    private static Main_menu_view main_menu;
    private  Model model = new Model();

    private JPanel panelLogin = new JPanel();
    private JLabel labelLogin = new JLabel("Identifiant");
    private JLabel labelPass = new JLabel("Mot de passe");
    private JTextField tfLogin = new JTextField(20);
    private JPasswordField tfPass = new JPasswordField(20);
    private JButton btnSubmit = new JButton("Envoyer");

    public Main_view() {
        model.addObserver(this);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 100);
        this.setSize(1000, 600);
        this.setTitle("Jismen");
        this.setMinimumSize(new Dimension(800, 600));
        this.setResizable(true);
        this.main_menu = new Main_menu_view();
        main_menu.setVisible(false);
        this.setJMenuBar(main_menu);
        panelLogin.add(labelLogin);
        panelLogin.add(tfLogin);
        panelLogin.add(labelPass);
        panelLogin.add(tfPass);
        panelLogin.add(btnSubmit);
        this.setContentPane(panelLogin);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.login(tfLogin.getText(), String.valueOf(tfPass.getPassword()));
            }
        });

        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null){
            main_menu.setVisible(true);
            getContentPane().setVisible(false);
            setContentPane(new Landing_page(this.getContentPane().getBounds()));
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Identifiants incorrects",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
