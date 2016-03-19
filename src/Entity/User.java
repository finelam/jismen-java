package Entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Finelam on 19/01/2016.
 */
public class User {
    private int id;
    private String username;
    private String email;
    private boolean enabled;
    private String salt;
    private String password;
    private Timestamp last_login;
    private boolean locked;
    private boolean expired;
    private Timestamp expires_at;
    private String confirmation_token;
    private Timestamp password_requested_at;
    private String roles;
    private boolean credentials_expired;
    private Timestamp credentials_expire_at;
    private boolean newsletter;
    private String firstname;
    private String familyname;
    private String address;
    private String postal_code;
    private String city;
    private Date birthday;
    private int nb_connection;
    private String username_canonical;
    private String email_canonical;

    public User(int id, String username, String email, boolean enabled, String salt, String password, Timestamp last_login, boolean locked, boolean expired, Timestamp expires_at, String confirmation_token, Timestamp password_requested_at, String roles, boolean credentials_expired, Timestamp credentials_expire_at, boolean newsletter, String firstname, String familyname, String address, String postal_code, String city, Date birthday, int nb_connection, String username_canonical, String email_canonical) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = last_login;
        this.locked = locked;
        this.expired = expired;
        this.expires_at = expires_at;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.roles = roles;
        this.credentials_expired = credentials_expired;
        this.credentials_expire_at = credentials_expire_at;
        this.newsletter = newsletter;
        this.firstname = firstname;
        this.familyname = familyname;
        this.address = address;
        this.postal_code = postal_code;
        this.city = city;
        this.birthday = birthday;
        this.nb_connection = nb_connection;
        this.username_canonical = username_canonical;
        this.email_canonical = email_canonical;
    }

    public User() {
        this.id = 0;
        this.username = "";
        this.email = "";
        this.enabled = false;
        this.salt = "";
        this.password = "";
        this.last_login = null;
        this.locked = false;
        this.expired = false;
        this.expires_at = null;
        this.confirmation_token = "";
        this.password_requested_at = null;
        this.roles = "";
        this.credentials_expired = false;
        this.credentials_expire_at = null;
        this.newsletter = false;
        this.firstname = "";
        this.familyname = "";
        this.address = "";
        this.postal_code = "";
        this.city = "";
        this.birthday = null;
        this.nb_connection = 0;
        this.username_canonical = "";
        this.email_canonical = "";
    }

    public int getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (int) id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(Object username) {
        this.username = (String) username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = (String) email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = (boolean) enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(Object salt) {
        this.salt = (String) salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = (String) password;
    }

    public Timestamp getLast_login() {
        return last_login;
    }

    public void setLast_login(Object last_login) {
        this.last_login = (Timestamp) last_login;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(Object locked) {
        this.locked = (boolean) locked;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(Object expired) {
        this.expired = (boolean) expired;
    }

    public Timestamp getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Object expires_at) {
        this.expires_at = (Timestamp) expires_at;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(Object confirmation_token) {
        this.confirmation_token = (String) confirmation_token;
    }

    public Timestamp getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Object password_requested_at) {
        this.password_requested_at = (Timestamp) password_requested_at;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(Object roles) {
        this.roles = (String) roles;
    }

    public boolean isCredentials_expired() {
        return credentials_expired;
    }

    public void setCredentials_expired(Object credentials_expired) {
        this.credentials_expired = (boolean) credentials_expired;
    }

    public Timestamp getCredentials_expire_at() {
        return credentials_expire_at;
    }

    public void setCredentials_expire_at(Object credentials_expire_at) {
        this.credentials_expire_at = (Timestamp) credentials_expire_at;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Object newsletter) {
        this.newsletter = (boolean) newsletter;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(Object firstname) {
        this.firstname = (String) firstname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(Object familyname) {
        this.familyname = (String) familyname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = (String) address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(Object postal_code) {
        this.postal_code = (String) postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = (String) city;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = (Date) birthday;
    }

    public int getNb_connection() {
        return nb_connection;
    }

    public void setNb_connection(Object nb_connection) {
        this.nb_connection = (int) nb_connection;
    }

    public String getUsername_canonical(){ return username_canonical; }

    public void setUsername_canonical(Object username_canonical){
        this.username_canonical = (String) username_canonical;
    }

    public String getEmail_canonical(){ return email_canonical; }

    public void setEmail_canonical(Object email_canonical){
        this.email_canonical = (String) email_canonical;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", last_login=" + last_login +
                ", locked=" + locked +
                ", expired=" + expired +
                ", expires_at=" + expires_at +
                ", confirmation_token='" + confirmation_token + '\'' +
                ", password_requested_at=" + password_requested_at +
                ", roles='" + roles + '\'' +
                ", credentials_expired=" + credentials_expired +
                ", credentials_expire_at=" + credentials_expire_at +
                ", newsletter=" + newsletter +
                ", firstname='" + firstname + '\'' +
                ", familyname='" + familyname + '\'' +
                ", address='" + address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", city='" + city + '\'' +
                ", birthday=" + birthday +
                ", nb_connection=" + nb_connection +
                ", username_canonical=" + username_canonical +
                ", email_canonical=" + email_canonical +
                '}';
    }
}
