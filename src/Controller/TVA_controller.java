package Controller;

import Entity.TVA;
import Model.TVA_model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class TVA_controller {
    private TVA_model model;

    public TVA_controller(TVA_model model){
        this.model = model;
    }

    public LinkedList<TVA> getAllTva(){
        LinkedList<Object> obj =  model.getAll("TVA");
        LinkedList<TVA> tvas = new LinkedList<>();
        for (Object o : obj){
            tvas.add((TVA) o);
        }
        return tvas;
    }

    public void edit(TVA tva){
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", tva.getId());
        values.put("rate", tva.getRate());
        model.edit("tva", values);
    }

    /**
     * Crée en base l'entité donnée en paramètre
     * @param tva
     */
    public void addTva(TVA tva){
        HashMap<String, Object> values = new HashMap<>();
        values.put("rate", tva.getRate());
        model.add("tva", values);
    }

    public void delete(TVA tva){
        model.delete("tva", tva.getId());
    }
}
