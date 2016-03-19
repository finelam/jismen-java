package Controller;

import Entity.Sub_category;
import Model.Sub_category_model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Sub_category_controller {

    private Sub_category_model model;

    public Sub_category_controller(Sub_category_model model){
        this.model = model;
    }

    /**
     * Récupère et renvoie la liste des cous-catégories
     * @return LinkedList<Sub_category>
     */
    public LinkedList<Sub_category> getAllSubCategories(){
        LinkedList<Object> obj =  model.getAll("Sub_category");
        LinkedList<Sub_category> subcats = new LinkedList<>();
        for (Object o : obj){
            subcats.add((Sub_category) o);
        }
        return subcats;
    }

    /**
     * Convertit l'entité en HashMap et l'envoie au model pour modification
     * @param sub
     */
    public void edit(Sub_category sub){
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", sub.getId());
        values.put("name", sub.getName());
        values.put("category_id", sub.getCategory_id());
        model.edit("sub_category", values);
    }

    /**
     * Crée en base l'entité donnée en paramètre
     * @param sub
     */
    public void addSubCategory(Sub_category sub){
        HashMap<String, Object> values = new HashMap<>();
        values.put("name", sub.getName());
        values.put("category_id", sub.getCategory_id());
        values.put("enabled", sub.isEnabled() ? 1 : 0);
        model.add("sub_category", values);
    }

    /**
     * Envoie au model la table et l'id à supprimer
     * @param sub
     */
    public void delete(Sub_category sub){
        model.delete("sub_category", sub.getId());
    }
}
