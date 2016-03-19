package View.Menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Finelam on 20/01/2016.
 */
public class Main_menu_view extends JMenuBar {
    private View_Menu_Accueil menu_accueil              = new View_Menu_Accueil();
    private View_Menu_User menu_user                    = new View_Menu_User();
    private View_Menu_Category menu_category            = new View_Menu_Category();
    private View_Menu_Sub_category menu_sub_category    = new View_Menu_Sub_category();
    private View_Menu_Product menu_product              = new View_Menu_Product();
    private View_Menu_Command menu_command                = new View_Menu_Command();
    private View_Menu_Size menu_size                    = new View_Menu_Size();
    private View_Menu_Color menu_color                  = new View_Menu_Color();
    private View_Menu_TVA menu_tva                      = new View_Menu_TVA();
    private View_Menu_Supplier menu_supplier            = new View_Menu_Supplier();

    public Main_menu_view() {
        this.setLayout(new GridLayout(1, 10));
        this.add(this.menu_accueil);
        this.add(this.menu_user);
        this.add(this.menu_category);
        this.add(this.menu_sub_category);
        this.add(this.menu_product);
//        this.add(this.menu_command);
        this.add(this.menu_size);
        this.add(this.menu_color);
        this.add(this.menu_tva);
        this.add(this.menu_supplier);

        this.setVisible(true);
    }

    public View_Menu_Accueil getMenu_accueil() {
        return menu_accueil;
    }

    public void setMenu_accueil(View_Menu_Accueil menu_accueil) {
        this.menu_accueil = menu_accueil;
    }

    public View_Menu_User getMenu_user() {
        return menu_user;
    }

    public void setMenu_user(View_Menu_User menu_user) {
        this.menu_user = menu_user;
    }

    public View_Menu_Product getMenu_product() {
        return menu_product;
    }

    public void setMenu_product(View_Menu_Product menu_product) {
        this.menu_product = menu_product;
    }

    public View_Menu_Category getMenu_category() {
        return menu_category;
    }

    public void setMenu_category(View_Menu_Category menu_category) {
        this.menu_category = menu_category;
    }

    public View_Menu_Sub_category getMenu_sub_category() {
        return menu_sub_category;
    }

    public void setMenu_sub_category(View_Menu_Sub_category menu_sub_category) {
        this.menu_sub_category = menu_sub_category;
    }

    public View_Menu_Size getMenu_size() {
        return menu_size;
    }

    public void setMenu_size(View_Menu_Size menu_size) {
        this.menu_size = menu_size;
    }

    public View_Menu_Color getMenu_color() {
        return menu_color;
    }

    public void setMenu_color(View_Menu_Color menu_color) {
        this.menu_color = menu_color;
    }

    public View_Menu_TVA getMenu_tva() {
        return menu_tva;
    }

    public void setMenu_tva(View_Menu_TVA menu_tva) {
        this.menu_tva = menu_tva;
    }

    public View_Menu_Supplier getMenu_supplier() {
        return menu_supplier;
    }

    public void setMenu_supplier(View_Menu_Supplier menu_supplier) {
        this.menu_supplier = menu_supplier;
    }
}
