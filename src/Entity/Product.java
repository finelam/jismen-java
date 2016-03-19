package Entity;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Product {
    private int id;
    private int sub_category_id;
    private int tva_id;
    private int color_id;
    private int size_id;
    private int supplier_id;
    private String name;
    private double priceht;
    private double pricettc;
    private int quantity;
    private boolean enabled;
    private boolean news;
    private boolean promo;
    private boolean vip;
    private String path;
    private String description;

    public Product(int id, int sub_category_id, int tva_id, int color_id, int size_id, int supplier_id, String name, double priceht, double pricettc, int quantity, boolean enabled, boolean news, boolean promo, boolean vip, String path, String description) {
        this.id = id;
        this.sub_category_id = sub_category_id;
        this.tva_id = tva_id;
        this.color_id = color_id;
        this.size_id = size_id;
        this.supplier_id = supplier_id;
        this.name = name;
        this.priceht = priceht;
        this.pricettc = pricettc;
        this.quantity = quantity;
        this.enabled = enabled;
        this.news = news;
        this.promo = promo;
        this.vip = vip;
        this.path = path;
        this.description = description;
    }

    public Product() {
        this.id = 0;
        this.sub_category_id = 0;
        this.tva_id = 0;
        this.color_id = 0;
        this.size_id = 0;
        this.supplier_id = 0;
        this.name = "";
        this.priceht = 0;
        this.pricettc = 0;
        this.quantity = 0;
        this.enabled = false;
        this.news = false;
        this.promo = false;
        this.vip = false;
        this.path = "";
        this.description = "";
    }

    public int getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (int) id;
    }

    public int getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(Object sub_category_id) {
        this.sub_category_id = (int) sub_category_id;
    }

    public int getTva_id() {
        return tva_id;
    }

    public void setTva_id(Object tva_id) {
        this.tva_id = (int) tva_id;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(Object color_id) {
        this.color_id = (int) color_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(Object size_id) {
        this.size_id = (int) size_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Object supplier_id) {
        this.supplier_id = (int) supplier_id;
    }

    public String getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = (String) name;
    }

    public double getPriceht() {
        return priceht;
    }

    public void setPriceht(Object priceht) {
        this.priceht = (double) priceht;
    }

    public double getPricettc() {
        return pricettc;
    }

    public void setPricettc(Object pricettc) {
        this.pricettc = (double) pricettc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Object quantity) {
        this.quantity = (int) quantity;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = (boolean) enabled;
    }

    public boolean isNews() {
        return news;
    }

    public void setNew(Object news) {
        this.news = (boolean) news;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(Object promo) {
        this.promo = (boolean) promo;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(Object vip) {
        this.vip = (boolean) vip;
    }

    public String getPath() {
        return path;
    }

    public void setPath(Object path) {
        this.path = (String) path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = (String) description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sub_category_id=" + sub_category_id +
                ", tva_id=" + tva_id +
                ", color_id=" + color_id +
                ", size_id=" + size_id +
                ", supplier_id=" + supplier_id +
                ", name='" + name + '\'' +
                ", priceht=" + priceht +
                ", pricettc=" + pricettc +
                ", quantity=" + quantity +
                ", enabled=" + enabled +
                ", news=" + news +
                ", promo=" + promo +
                ", vip=" + vip +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
