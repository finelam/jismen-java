package Model;

import Entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class User_model extends Model{

//    public LinkedList<Object> getAll(String name){
//        LinkedList<Object> users = new LinkedList<>();
//        db.connect();
//        String query = "SELECT * FROM user;";
//
//        try {
//            Statement stat = db.getConnexion().createStatement();
//            ResultSet res = stat.executeQuery(query);
//            while (res.next()){
//                User user = new User();
//                user.setId(res.getInt("id"));
//                user.setUsername(res.getString("username"));
//                user.setUsername_canonical(res.getString("username_canonical"));
//                user.setEmail(res.getString("email"));
//                user.setEmail_canonical(res.getString("email_canonical"));
//                user.setEnabled(res.getBoolean("enabled"));
//                user.setSalt(res.getString("salt"));
//                user.setPassword(res.getString("password"));
//                user.setLast_login(res.getTimestamp("last_login"));
//                user.setLocked(res.getBoolean("locked"));
//                user.setExpired(res.getBoolean("expired"));
//                user.setExpires_at(res.getTimestamp("expires_at"));
//                user.setConfirmtion_token(res.getString("confirmation_token"));
//                user.setPassword_requested_at(res.getTimestamp("password_requested_at"));
//                user.setRole(res.getString("roles"));
//                user.setCredentials_expired(res.getBoolean("credentials_expired"));
//                user.setCredentials_expire_at(res.getTimestamp("credentials_expire_at"));
//                user.setNewsletter(res.getBoolean("newsletter"));
//                user.setFirstname(res.getString("firstname"));
//                user.setFamilyname(res.getString("familyname"));
//                user.setAddress(res.getString("address"));
//                user.setPostal_code(res.getString("postal_code"));
//                user.setCity(res.getString("city"));
//                user.setBirthday(res.getTimestamp("birthday"));
//                user.setNb_connection(res.getInt("nb_connection"));
//                users.add(user);
//            }
//            stat.close();
//            res.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        db.disconnect();
//        return users;
//    }

}
