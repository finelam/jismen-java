package View.User;

import Controller.User_controller;
import Entity.User;
import Model.User_model;
import layout.View_add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_user_add extends View_add {
    private User_model model        = new User_model();
    private User_controller controller = new User_controller(model);

    private JPanel panelName        = new JPanel();
    private JPanel panelFirstname   = new JPanel();
    private JPanel panelBirthday    = new JPanel();
    private JPanel panelEmail       = new JPanel();
    private JPanel panelPass        = new JPanel();
    private JPanel panelAddress     = new JPanel();
    private JPanel panelPC          = new JPanel();
    private JPanel panelCity        = new JPanel();
    private JPanel panelEnabled     = new JPanel();
    private JPanel panelNL          = new JPanel();

    private JLabel labelName        = new JLabel("Nom : ");
    private JLabel labelFirstname   = new JLabel("Prénom : ");
    private JLabel labelBirthday    = new JLabel("Date de naissance : ");
    private JLabel labelEmail       = new JLabel("Email : ");
    private JLabel labelPass        = new JLabel("Mot de passe : ");
    private JLabel labelAddress     = new JLabel("Adresse : ");
    private JLabel labelPC          = new JLabel("Code postal : ");
    private JLabel labelCity        = new JLabel("Ville : ");
    private JLabel labelEnabled     = new JLabel("Activer : ");
    private JLabel labelNL          = new JLabel("Newletter : ");

    private JTextField tfName       = new JTextField(20);
    private JTextField tfFirstname  = new JTextField(20);
    private JTextField tfBirthday   = new JTextField(20);
    private JTextField tfEmail      = new JTextField(20);
    private JTextField tfPass       = new JTextField(20);
    private JTextField tfAddress    = new JTextField(20);
    private JTextField tfPC         = new JTextField(20);
    private JTextField tfCity       = new JTextField(20);
    private JTextField tfEnabled    = new JTextField(20);
    private JTextField tfNL         = new JTextField(20);

    public View_user_add(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Nouvel utilisateur");
        model.addObserver(this);
        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);
        panelFirstname.add(labelFirstname);
        panelFirstname.add(tfFirstname);
        dataPanel.add(panelFirstname);
        panelBirthday.add(labelBirthday);
        panelBirthday.add(tfBirthday);
        dataPanel.add(panelBirthday);
        panelEmail.add(labelEmail);
        panelEmail.add(tfEmail);
        dataPanel.add(panelEmail);
        panelPass.add(labelPass);
        panelPass.add(tfPass);
        dataPanel.add(panelPass);
        panelAddress.add(labelAddress);
        panelAddress.add(tfAddress);
        dataPanel.add(panelAddress);
        panelPC.add(labelPC);
        panelPC.add(tfPC);
        dataPanel.add(panelPC);
        panelCity.add(labelCity);
        panelCity.add(tfCity);
        dataPanel.add(panelCity);
        panelEnabled.add(labelEnabled);
        panelEnabled.add(tfEnabled);
        dataPanel.add(panelEnabled);
        panelNL.add(labelNL);
        panelNL.add(tfNL);
        dataPanel.add(panelNL);


        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();

                controller.addUser(user);
            }
        });
    }
}
