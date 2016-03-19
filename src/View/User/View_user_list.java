package View.User;

import Controller.User_controller;
import Entity.User;
import Model.User_model;
import layout.View_list;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_user_list extends View_list {

    private LinkedList<User> users;
    private User_model model;
    private User_controller controller;

    public View_user_list(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Liste des utilisateurs");
        model = new User_model();
        controller = new User_controller(model);
        users = controller.getAllUsers();
        String headers[] = {"Id", "Username", "Ville", "Email", "Dernière visite", "Actions"};
        Object data [][] = new Object[users.size()][headers.length];
        int i = 0;
        for (Object o : users){
            User u = (User) o;
            data[i][0] = u.getId();
            data[i][1] = u.getUsername();
            data[i][2] = u.getCity() + " (" + u.getPostal_code() + ")";
            data[i][3] = u.getEmail();
            data[i][4] = u.getLast_login();
            data[i][5] = null;
            i++;
        }
        table = new JTable(data, headers);
        scroll = new JScrollPane(table);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
    }
}
