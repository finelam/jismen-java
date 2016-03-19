package Entity;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Command {
    private int id;
    private  int user_id;
    private String paiement;
    private String address;
    private String postal_code;
    private String city;
    private String recipient;
    private String state;

    public Command(int id, int user_id, String paiement, String address, String postal_code, String city, String recipient, String state) {
        this.id = id;
        this.user_id = user_id;
        this.paiement = paiement;
        this.address = address;
        this.postal_code = postal_code;
        this.city = city;
        this.recipient = recipient;
        this.state = state;
    }

    public Command() {
        this.id = 0;
        this.user_id = 0;
        this.paiement = "";
        this.address = "";
        this.postal_code = "";
        this.city = "";
        this.recipient = "";
        this.state = "";
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", paiement='" + paiement + '\'' +
                ", address='" + address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", city='" + city + '\'' +
                ", recipient='" + recipient + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
