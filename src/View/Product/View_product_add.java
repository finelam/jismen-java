package View.Product;

import Controller.Product_controller;
import Entity.Product;
import Model.Product_model;
import layout.View_add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_product_add extends View_add {
    private Product_model model = new Product_model();
    private Product_controller controller = new Product_controller(model);

    private JPanel panelSubCat      = new JPanel();
    private JPanel panelTva         = new JPanel();
    private JPanel panelColor       = new JPanel();
    private JPanel panelSize        = new JPanel();
    private JPanel panelSupplier    = new JPanel();
    private JPanel panelName        = new JPanel();
    private JPanel panelPriceht     = new JPanel();
    private JPanel panelQuantity    = new JPanel();
    private JPanel panelEnabled     = new JPanel();
    private JPanel panelNews        = new JPanel();
    private JPanel panelPromo       = new JPanel();
    private JPanel panelVip         = new JPanel();
    private JPanel panelPath        = new JPanel();
    private JPanel panelDescription = new JPanel();

    private JLabel labelSubCat      = new JLabel("Sous-catégorie : ");
    private JLabel labelTva         = new JLabel("TVA : ");
    private JLabel labelColor       = new JLabel("Couleur : ");
    private JLabel labelSize        = new JLabel("Taille : ");
    private JLabel labelSupplier    = new JLabel("Fournisseur : ");
    private JLabel labelName        = new JLabel("Nom : ");
    private JLabel labelPriceht     = new JLabel("Prix HT : ");
    private JLabel labelQuantity    = new JLabel("Quantité : ");
    private JLabel labelEnabled     = new JLabel("Afficher : ");
    private JLabel labelNews        = new JLabel("Nouveauté : ");
    private JLabel labelPromo       = new JLabel("Promo : ");
    private JLabel labelVip         = new JLabel("VIP : ");
    private JLabel labelPath        = new JLabel("Image : ");
    private JLabel labelDescription = new JLabel("Description : ");

    private JTextField tfSubCat     = new JTextField(20);
    private JTextField tfTva        = new JTextField(20);
    private JTextField tfColor      = new JTextField(20);
    private JTextField tfSize       = new JTextField(20);
    private JTextField tfSupplier   = new JTextField(20);
    private JTextField tfName       = new JTextField(20);
    private JTextField tfPriceht    = new JTextField(20);
    private JTextField tfQuantity   = new JTextField(20);
    private JTextField tfPath       = new JTextField(20);
    private JTextField tfDescription= new JTextField(20);
    private JCheckBox cbEnabled     = new JCheckBox();
    private JCheckBox cbNews        = new JCheckBox();
    private JCheckBox cbPromo       = new JCheckBox();
    private JCheckBox cbVip         = new JCheckBox();

    public View_product_add(Rectangle bounds) {
        super(bounds);
        labelHeader.setText("Nouveau produit");
        model.addObserver(this);

        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelName);
        panelDescription.add(labelDescription);
        panelDescription.add(tfDescription);
        dataPanel.add(panelDescription);
        panelEnabled.add(labelEnabled);
        panelEnabled.add(cbEnabled);
        dataPanel.add(panelEnabled);
        panelNews.add(labelNews);
        panelNews.add(cbNews);
        dataPanel.add(panelNews);
        panelVip.add(labelVip);
        panelVip.add(cbVip);
        dataPanel.add(panelVip);
        panelPromo.add(labelPromo);
        panelPromo.add(cbPromo);
        dataPanel.add(panelPromo);
        panelPriceht.add(labelPriceht);
        panelPriceht.add(tfPriceht);
        dataPanel.add(panelPriceht);
        panelQuantity.add(labelQuantity);
        panelQuantity.add(tfQuantity);
        dataPanel.add(panelQuantity);
        panelSubCat.add(labelSubCat);
        panelSubCat.add(tfSubCat);
        dataPanel.add(panelSubCat);
        panelSupplier.add(labelSupplier);
        panelSupplier.add(tfSupplier);
        dataPanel.add(panelSupplier);
        panelTva.add(labelTva);
        panelTva.add(tfTva);
        dataPanel.add(panelTva);
        panelSize.add(labelSize);
        panelSize.add(tfSize);
        dataPanel.add(panelSize);
        panelColor.add(labelColor);
        panelColor.add(tfColor);
        dataPanel.add(panelColor);
        panelPath.add(labelPath);
        panelPath.add(tfPath);
        dataPanel.add(panelPath);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product product = new Product();
                product.setName(tfName.getText());
                product.setDescription(tfDescription.getText());
                product.setEnabled(cbEnabled.isSelected());
                product.setNew(cbNews.isSelected());
                product.setVip(cbVip.isSelected());
                product.setPromo(cbPromo.isSelected());
                product.setColor_id(Integer.valueOf(tfColor.getText()));
                product.setTva_id(Integer.valueOf(tfTva.getText()));
                product.setSize_id(Integer.valueOf(tfSize.getText()));
                product.setSub_category_id(Integer.valueOf(tfSubCat.getText()));
                product.setSupplier_id(Integer.valueOf(tfSupplier.getText()));
                product.setQuantity(Integer.valueOf(tfQuantity.getText()));
                product.setPriceht(Double.valueOf(tfPriceht.getText()));
                product.setPath(tfPath.getText());
                controller.addProduct(product);
            }
        });
    }
}
