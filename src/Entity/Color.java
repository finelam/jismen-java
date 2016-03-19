package Entity;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Color {
    private int id;
    private String name;

    public Color() {
        this.id = -1;
        this.name = "";
    }

    public Color(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (int)id;
    }

    public String getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = (String) name;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
