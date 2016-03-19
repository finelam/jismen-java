package Controller;

import Entity.Command;
import Model.Command_model;

import java.util.LinkedList;
import java.util.Observer;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Command_controller {
    private Command_model model;

    public Command_controller(Command_model model){
        this.model = model;
    }

    public LinkedList<Command> getAllCommands(){
        LinkedList<Object> obj =  model.getAll("Command");
        LinkedList<Command> commands = new LinkedList<Command>();
        for (Object o : obj){
            commands.add((Command)o);
        }
        return commands;
    }
}
