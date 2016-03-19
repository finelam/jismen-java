package Controller;

import javax.swing.*;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Created by Finelam on 31/01/2016.
 */
public class Db_controller {
    private Connection connexion;
    String server, user, pass, db;

    public Db_controller(String server, String user, String pass, String db){
        this.connexion  = null;
        this.server     = server;
        this.user       = user;
        this.pass       = pass;
        this.db         = db;
    }

    public Db_controller(){
        this.server = "192.168.56.101";
        this.user   = "root";
        this.pass   = "root";
        this.db     = "jismen_symfony";
    }

    private void load_driver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException exp){
            System.out.println("Db driver not found !");
        }
    }

    public void connect(){
        this.load_driver();
        String url = "mysql://" + this.server + "/" + this.db;
        try {
            this.connexion = DriverManager.getConnection("jdbc:" + url, this.user, this.pass);
        } catch (SQLException exp){
            System.out.println("Connection error : " + exp);
        }
    }

    public void disconnect(){
        try {
            if (this.connexion != null){
                this.connexion.close();
            }
        }catch (SQLException exp){
            System.out.println("Unavailable to disconnect : " + exp);
        }
    }

    public Connection getConnexion(){
        return this.connexion;
    }
}
