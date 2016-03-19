package Entity;

/**
 * Created by Finelam on 19/01/2016.
 */
public class TVA {
    private int id;
    private double rate;

    public TVA(int id, double rate) {
        this.id = id;
        this.rate = rate;
    }

    public TVA() {
        this.id = 0;
        this.rate = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (int) id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = (double) rate;
    }

    @Override
    public String toString() {
        return "TVA{" +
                "id=" + id +
                ", rate=" + rate +
                '}';
    }
}
