package Controller;

import Entity.Supplier;
import Model.Supplier_model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Supplier_controller {

    private Supplier_model model;

    public Supplier_controller(Supplier_model model){
        this.model = model;
    }

    /**
     * Récupère et renvoie la liste des fournisseurs
     * @return LinkedList<Supplier>
     */
    public LinkedList<Supplier> getAllSuppliers(){
        LinkedList<Object> obj = model.getAll("Supplier");
        LinkedList<Supplier> suppliers = new LinkedList<>();
        for (Object o : obj){
            suppliers.add((Supplier) o);
        }
        return suppliers;
    }

    /**
     * Convertit l'entité en HashMap et l'envoie au model pour modification
     * @param s
     */
    public void edit(Supplier s){
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", s.getId());
        values.put("name", s.getName());
        values.put("address", s.getAddress());
        values.put("postal_code", s.getPostal_code());
        values.put("city", s.getCity());
        values.put("contract", s.getContract());
        model.edit("supplier", values);
    }

    /**
     * Crée en base l'entité donnée en paramètre
     * @param s
     */
    public void addSupplier(Supplier s){
        HashMap<String, Object> values = new HashMap<>();
        values.put("name", s.getName());
        values.put("address", s.getAddress());
        values.put("postal_code", s.getPostal_code());
        values.put("city", s.getCity());
        values.put("contract", s.getContract());
        model.add("supplier", values);
    }

    /**
     * Envoie au model la table et l'id à supprimer
     * @param s
     */
    public void delete(Supplier s){
        model.delete("supplier", s.getId());
    }
}

