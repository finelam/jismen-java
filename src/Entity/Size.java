package Entity;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Size {

    private int id;
    private String name;

    public Size(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Size() {
        this.id = 0;
        this.name = "";
    }

    public int getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (int) id;
    }

    public String getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = (String) name;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
