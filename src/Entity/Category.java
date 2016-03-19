package Entity;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Category {
    private int id;
    private String name;
    private boolean enabled;

    public Category() {
        this.id = 0;
        this.name = "";
        this.enabled = false;
    }

    public Category(int id, String name, boolean enabled) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
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
        this.name = (String)name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = (boolean)enabled;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
