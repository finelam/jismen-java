package View.Product;

import Controller.Product_controller;
import Entity.Product;
import Model.Product_model;
import layout.View_show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by Finelam on 29/01/2016.
 */
public class View_product_show extends View_show {

    private Product_model model;
    private Product_controller controller;
    private LinkedList<Product> products;
    private Product product;

    JPanel panelId           = new JPanel();
    JPanel panelSubCat       = new JPanel();
    JPanel panelTva          = new JPanel();
    JPanel panelColor        = new JPanel();
    JPanel panelSize         = new JPanel();
    JPanel panelSupplier     = new JPanel();
    JPanel panelName         = new JPanel();
    JPanel panelPriceHt      = new JPanel();
    JPanel panelPriceTtc     = new JPanel();
    JPanel panelQuantity     = new JPanel();
    JPanel panelEnabled      = new JPanel();
    JPanel panelNews         = new JPanel();
    JPanel panelPromo        = new JPanel();
    JPanel panelVip          = new JPanel();
    JPanel panelPath         = new JPanel();
    JPanel panelDescription  = new JPanel();

    private JLabel labelId          = new JLabel("Id : ");
    private JLabel labelSubCat      = new JLabel("Sous-categorie : ");
    private JLabel labelTva         = new JLabel("TVA : ");
    private JLabel labelColor       = new JLabel("Couleur : ");
    private JLabel labelSize        = new JLabel("Taille : ");
    private JLabel labelSupplier    = new JLabel("Fournisseur : ");
    private JLabel labelName        = new JLabel("Nom : ");
    private JLabel labelPriceHt     = new JLabel("Prix HT : ");
    private JLabel getLabelPriceTtc = new JLabel("Prix TTC : ");
    private JLabel labelQuantity    = new JLabel("Quantité : ");
    private JLabel labelEnabled     = new JLabel("Afficher : ");
    private JLabel labelNews        = new JLabel("Nouveauté : ");
    private JLabel labelPromo       = new JLabel("Promo : ");
    private JLabel labelVip         = new JLabel("VIP : ");
    private JLabel labelPath        = new JLabel("Image : ");
    private JLabel labelDescription = new JLabel("Description : ");

    private JTextField tfId         = new JTextField(20);
    private JTextField tfSubCat     = new JTextField(20);
    private JTextField tfTva        = new JTextField(20);
    private JTextField tfColor      = new JTextField(20);
    private JTextField tfSize       = new JTextField(20);
    private JTextField tfSupplier   = new JTextField(20);
    private JTextField tfName       = new JTextField(20);
    private JTextField tfPriceHt    = new JTextField(20);
    private JTextField tfPriceTtc   = new JTextField(20);
    private JTextField tfQuantity   = new JTextField(20);
    private JCheckBox cbEnabled     = new JCheckBox();
    private JCheckBox cbNews        = new JCheckBox();
    private JCheckBox cbPromo       = new JCheckBox();
    private JCheckBox cbVip         = new JCheckBox();
    private JTextField tfPath       = new JTextField(20);
    private JTextField tfDescription= new JTextField(20);

    public View_product_show(Rectangle bounds) {
        super(bounds);
        model       = new Product_model();
        model.addObserver(this);
        controller  = new Product_controller(model);
        initCombo();
        product     = products.getFirst();
        updateFields();

        tfId.setEditable(false);
        panelId.add(labelId);
        panelId.add(tfId);
        dataPanel.add(panelId);
        panelName.add(labelName);
        panelName.add(tfName);
        dataPanel.add(panelId);
        panelDescription.add(labelDescription);
        panelDescription.add(tfDescription);
        dataPanel.add(panelDescription);
        panelPriceHt.add(labelPriceHt);
        panelPriceHt.add(tfPriceHt);
        dataPanel.add(panelPriceHt);
        panelPriceTtc.add(getLabelPriceTtc);
        panelPriceTtc.add(tfPriceTtc);
        dataPanel.add(panelPriceTtc);
        panelQuantity.add(labelQuantity);
        panelQuantity.add(tfQuantity);
        dataPanel.add(panelQuantity);
        panelSupplier.add(labelSupplier);
        panelSupplier.add(tfSupplier);
        dataPanel.add(panelSupplier);
        panelSubCat.add(labelSubCat);
        panelSubCat.add(tfSubCat);
        dataPanel.add(panelSubCat);
        panelColor.add(labelColor);
        panelColor.add(tfColor);
        dataPanel.add(panelColor);
        panelSize.add(labelSize);
        panelSize.add(tfSize);
        dataPanel.add(panelSize);
        panelTva.add(labelTva);
        panelTva.add(tfTva);
        dataPanel.add(panelTva);
        panelPath.add(labelPath);
        panelPath.add(tfPath);
        dataPanel.add(panelPath);
        panelEnabled.add(labelEnabled);
        panelEnabled.add(cbEnabled);
        dataPanel.add(panelEnabled);
        panelNews.add(labelNews);
        panelNews.add(cbNews);
        dataPanel.add(panelNews);
        panelPromo.add(labelPromo);
        panelPromo.add(cbPromo);
        dataPanel.add(panelPromo);
        panelVip.add(labelVip);
        panelVip.add(cbVip);
        dataPanel.add(panelVip);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProduct();
                controller.edit(product);
                initCombo();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.delete(product);
                product = new Product();
                updateFields();
                initCombo();
            }
        });
    }

    private void initCombo(){
        comboPanel.removeAll();
        combo = new JComboBox();
        products = controller.getAllProducts();
        for (Product p : products){
            combo.addItem(p);
        }
        comboPanel.add(combo);
        combo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Product){
                    Product prod = (Product) value;
                    setText(prod.getName());
                }
                return this;
            }
        });
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product = (Product)combo.getSelectedItem();
                updateFields();
            }
        });
    }

    private void updateFields(){
        tfId.setText(String.valueOf(product.getId()));
        tfSubCat.setText(String.valueOf(product.getSub_category_id()));
        tfTva.setText(String.valueOf(product.getTva_id()));
        tfColor.setText(String.valueOf(product.getColor_id()));
        tfSize.setText(String.valueOf(product.getSize_id()));
        tfSupplier.setText(String.valueOf(product.getSupplier_id()));
        tfName.setText(product.getName());
        tfPriceHt.setText(String.valueOf(product.getPriceht()));
        tfPriceTtc.setText(String.valueOf(product.getPricettc()));
        tfQuantity.setText(String.valueOf(product.getQuantity()));
        cbEnabled.setSelected(product.isEnabled());
        cbNews.setSelected(product.isNews());
        cbPromo.setSelected(product.isPromo());
        cbVip.setSelected(product.isVip());
        tfPath.setText((product.getPath()));
        tfDescription.setText(product.getDescription());
    }

    private void updateProduct(){
        product.setName(tfName.getText());
        product.setSub_category_id(Integer.valueOf(tfSubCat.getText()));
        product.setTva_id(Integer.valueOf(tfTva.getText()));
        product.setColor_id(Integer.valueOf(tfColor.getText()));
        product.setSize_id(Integer.valueOf(tfSize.getText()));
        product.setSupplier_id(Integer.valueOf(tfSupplier.getText()));
        product.setPriceht(Double.valueOf(tfPriceHt.getText()));
        product.setPricettc(Double.valueOf(tfPriceTtc.getText()));
        product.setQuantity(Integer.valueOf(tfQuantity.getText()));
        product.setEnabled(cbEnabled.isSelected());
        product.setNew(cbNews.isSelected());
        product.setPromo(cbPromo.isSelected());
        product.setVip(cbVip.isSelected());
        product.setPath(tfPath.getText());
        product.setDescription(tfDescription.getText());
    }
}
