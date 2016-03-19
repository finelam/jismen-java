package View.User;

import Controller.User_controller;
import Entity.User;
import Model.User_model;
import layout.View_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_user_show extends View_show {

    private User_model model;
    private User_controller controller;
    private LinkedList<User> users;
    private User user;

    private JPanel panelId              = new JPanel();
    private JPanel panelFamilyname      = new JPanel();
    private JPanel panelFirstname       = new JPanel();
    private JPanel panelEmail           = new JPanel();
    private JPanel panelAddress         = new JPanel();
    private JPanel panelPostal_code     = new JPanel();
    private JPanel panelCity            = new JPanel();
    private JPanel panelBirthday        = new JPanel();
    private JPanel panelLastlogin       = new JPanel();
    private JPanel panelNb_connection   = new JPanel();

    private JLabel labelId              = new JLabel("Id : ");
    private JLabel labelFamilyname      = new JLabel("Nom : ");
    private JLabel labelFirstname       = new JLabel("Prénom : ");
    private JLabel labelEmail           = new JLabel("Email : ");
    private JLabel labelAddress         = new JLabel("Adresse : ");
    private JLabel labelPostal_code     = new JLabel("Code postal : ");
    private JLabel labelCity            = new JLabel("Ville : ");
    private JLabel labelBirthday        = new JLabel("Date de naissance : ");
    private JLabel labelLastlogin       = new JLabel("Dernière connexion : ");
    private JLabel labelNb_connection   = new JLabel("Nb de connexions : ");

    private JTextField tfId             = new JTextField(20);
    private JTextField tfFamilyname     = new JTextField(20);
    private JTextField tfFirstname      = new JTextField(20);
    private JTextField tfEmail          = new JTextField(20);
    private JTextField tfAddress        = new JTextField(20);
    private JTextField tfPostal_code    = new JTextField(20);
    private JTextField tfCity           = new JTextField(20);
    private JTextField tfBirthday       = new JTextField(20);
    private JTextField tfLastlogin      = new JTextField(20);
    private JTextField tfNb_connection  = new JTextField(20);

    public View_user_show(Rectangle bounds) {
        super(bounds);
        model = new User_model();
        controller = new User_controller(model);
        initCombo();
        user = users.getFirst();
        updateFields();

        tfId.setEditable(false);
        panelId.add(labelId);
        panelId.add(tfId);
        dataPanel.add(panelId);
        panelFamilyname.add(labelFamilyname);
        panelFamilyname.add(tfFamilyname);
        dataPanel.add(panelFamilyname);
        panelFirstname.add(labelFirstname);
        panelFirstname.add(tfFirstname);
        dataPanel.add(panelFirstname);
        panelEmail.add(labelEmail);
        panelEmail.add(tfEmail);
        dataPanel.add(panelEmail);
        panelAddress.add(labelAddress);
        panelAddress.add(tfAddress);
        dataPanel.add(panelAddress);
        panelPostal_code.add(labelPostal_code);
        panelPostal_code.add(tfPostal_code);
        dataPanel.add(panelPostal_code);
        panelCity.add(labelCity);
        panelCity.add(tfCity);
        dataPanel.add(panelCity);
        panelBirthday.add(labelBirthday);
        panelBirthday.add(tfBirthday);
        dataPanel.add(panelBirthday);
        tfLastlogin.setEditable(false);
        panelLastlogin.add(labelLastlogin);
        panelLastlogin.add(tfLastlogin);
        dataPanel.add(panelLastlogin);
        tfNb_connection.setEditable(false);
        panelNb_connection.add(labelNb_connection);
        panelNb_connection.add(tfNb_connection);
        dataPanel.add(panelNb_connection);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setFamilyname(tfFamilyname.getText());
                user.setFirstname(tfFirstname.getText());
                user.setEmail(tfEmail.getText());
                user.setAddress(tfAddress.getText());
                user.setPassword(tfPostal_code.getText());
                user.setCity(tfCity.getText());
                System.out.println(tfBirthday.getText());
                if (tfBirthday.getText().equals("null")){
                    user.setBirthday(null);
                } else {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                        Date parsedDate = dateFormat.parse(tfBirthday.getText());
                        Timestamp ts = new Timestamp(parsedDate.getTime());
                        user.setBirthday(ts);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                }
                controller.edit(user);
                initCombo();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.delete(user);
                user = new User();
                updateFields();
                initCombo();
            }
        });
    }

    private void initCombo(){
        comboPanel.removeAll();
        combo = new JComboBox();
        users = controller.getAllUsers();
        for (User u : users){
            combo.addItem(u);
        }
        comboPanel.add(combo);
        combo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof User){
                    User u = (User) value;
                    setText(u.getUsername());
                }
                return this;
            }
        });
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = (User) combo.getSelectedItem();
                updateFields();
            }
        });
    }

    private void updateFields(){
        tfId.setText(String.valueOf(user.getId()));
        tfFamilyname.setText(user.getFamilyname());
        tfFirstname.setText(user.getFirstname());
        tfEmail.setText(user.getEmail());
        tfAddress.setText(user.getAddress());
        tfPostal_code.setText(user.getPostal_code());
        tfCity.setText(user.getCity());
        tfCity.setText(user.getCity());
        tfBirthday.setText(String.valueOf(user.getBirthday()));
        tfLastlogin.setText(String.valueOf(user.getLast_login()));
        tfNb_connection.setText(String.valueOf(user.getNb_connection()));
    }
}
