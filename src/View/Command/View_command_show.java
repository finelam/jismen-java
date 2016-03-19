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
public class View_command_show extends JPanel {

    private JPanel comboPanel = new JPanel();
    private JPanel dataPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JButton btnEdit = new JButton("Modifier");
    private JButton btnDel = new JButton("Supprimer");
    private JComboBox combo;

    private Command_model model;
    private Command_controller controller;
    private LinkedList<Command> commands;
    private  Command com;

    public View_command_show(Rectangle bounds) {
        model = new Command_model();
        controller = new Command_controller(model);
        initCombo();
        com = commands.getFirst();

        this.setBounds(bounds);
        this.setVisible(true);
    }

    private void initCombo(){
        commands = controller.getAllCommands();
        combo = new JComboBox();
        for (Command c : commands){
            combo.addItem(c);
        }
        combo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Command){
                    Command command = (Command) value;
                    setText(String.valueOf(command.getId()));
                }
                return this;
            }
        });
    }
}
