package Entity;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Sub_category {
    private int id;
    private int  category_id;
    private String name;
    private boolean enabled;

    public Sub_category(int id, int category_id, String name, boolean enabled) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.enabled = enabled;
    }

    public Sub_category() {
        this.id = 0;
        this.category_id = 0;
        this.name = "";
        this.enabled = false;
    }

    public int getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (int) id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Object category_id) {
        this.category_id = (int) category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = (String) name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = (boolean) enabled;
    }

    @Override
    public String toString() {
        return "Sub_category{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
