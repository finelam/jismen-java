package Controller;

import Entity.User;
import Model.User_model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class User_controller {
    private User_model model;

    public User_controller(User_model model){
        this.model = model;
    }

    /**
     * Récupère et renvoie la liste des utilisateurs
     * @return
     */
    public LinkedList<User> getAllUsers(){
        LinkedList<Object> obj =  model.getAll("User");
        LinkedList<User> users = new LinkedList<>();
        for (Object o : obj){
            users.add((User) o);
        }
        return users;
    }

    public void edit(User user){
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", user.getId());
        values.put("familyname", user.getFamilyname());
        values.put("firstname", user.getFirstname());
        values.put("email", user.getEmail());
        values.put("address", user.getAddress());
        values.put("postal_code", user.getPostal_code());
        values.put("city", user.getCity());
        values.put("birthday", user.getBirthday());
        model.edit("user", values);
    }

    /**
     * Crée en base l'entité donnée en paramètre
     * @param user
     */
    public void addUser(User user){
        HashMap<String, Object> values = new HashMap<>();
        values.put("familyname", user.getFamilyname());
        values.put("firstname", user.getFirstname());
        values.put("email", user.getEmail());
        values.put("address", user.getAddress());
        values.put("postal_code", user.getPostal_code());
        values.put("city", user.getCity());
        values.put("birthday", user.getBirthday());
        model.add("user", values);
    }

    public void delete(User user){
        model.delete("user", user.getId());
    }
}
