package View.Command;

import Controller.Command_controller;
import Entity.Command;
import Model.Command_model;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_command_list extends JPanel{

    private Command_controller controller;
    private Command_model model;
    private LinkedList<Command> commands;
    private JTable table;


    public View_command_list(Rectangle bounds) {
        this.setBounds(bounds);
        this.model = new Command_model();
        this.controller = new Command_controller(model);
        this.commands = controller.getAllCommands();
        String[] headers = {"Id", "User", "Paiement", "Adresse", "Code postal", "Ville", "Destinataire", "Etat"};
        Object[][] data = new Object[commands.size()][headers.length];
        int i = 0;
        for (Object obj : commands){
            Command command = (Command) obj;
            data[i][0] = command.getId();
            data[i][1] = command.getUser_id();
            data[i][2] = command.getPaiement();
            data[i][3] = command.getAddress();
            data[i][4] = command.getPostal_code();
            data[i][5] = command.getCity();
            data[i][6] = command.getRecipient();
            data[i][7] = command.getState();
            i++;
        }

        this.setLayout(new BorderLayout());
        this.table = new JTable(data, headers);
        JScrollPane scroll = new JScrollPane(this.table);
        scroll.setVisible(true);
        this.add(scroll, BorderLayout.CENTER);
    }
}
