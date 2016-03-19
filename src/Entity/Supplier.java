package Entity;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Supplier {
    private int id;
    private String name;
    private String address;
    private String postal_code;
    private String city;
    private String contract;

    public Supplier(int id, String name, String address, String postal_code, String city, String contract) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postal_code = postal_code;
        this.city = city;
        this.contract = contract;
    }

    public Supplier() {
        this.id = 0;
        this.name = "";
        this.address = "";
        this.postal_code = "";
        this.city = "";
        this.contract = "";
    }

    public int getId() {
        return id;
    }

    public void setId(Object id) { this.id = (int) id; }

    public String getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = (String) name;
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

    public String getContract() {
        return contract;
    }

    public void setContract(Object contract) {
        this.contract = (String) contract;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", city='" + city + '\'' +
                ", contract='" + contract + '\'' +
                '}';
    }
}
