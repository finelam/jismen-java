package Model;

import Controller.Db_controller;
import Entity.Command;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Observable;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Command_model extends Model {
    Db_controller db = new Db_controller();

    public LinkedList<Command> getAllCommands(){
        LinkedList<Command> commandList = new LinkedList<Command>();
        String query = "SELECT * FROM command;";
        db.connect();
        try {
            Statement stat = db.getConnexion().createStatement();
            ResultSet res = stat.executeQuery(query);
            while (res.next()){
                int id = res.getInt("id");
                int user_id = res.getInt("user_id");
                String paiement = res.getString("paiement");
                String address = res.getString("address");
                String postal_code = res.getString("postal_code");
                String city = res.getString("city");
                String recipient = res.getString("recipient");
                String state = res.getString("state");
                Command command = new Command(id, user_id, paiement, address, postal_code, city, recipient, state);
                commandList.add(command);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
        return commandList;
    }
}
