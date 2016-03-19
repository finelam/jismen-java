package Controller;

import Entity.Size;
import Model.Size_model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Size_controller {
    Size_model model;

    public Size_controller(Size_model model){
        this.model = model;
    }

    public LinkedList<Size> getAllSizes(){
        LinkedList<Object> obj =  model.getAll("Size");
        LinkedList<Size> sizes = new LinkedList<>();
        for (Object o : obj){
            sizes.add((Size) o);
        }
        return sizes;
    }

    public void edit(Size s){
        HashMap<String, Object> values = new HashMap<>();
        values.put("name", s.getName());
        model.edit("size", values);
    }

    /**
     * Crée en base la couleur donnée en paramètre
     * @param s
     */
    public void addSize(Size s){
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", s.getId());
        values.put("name", s.getName());
        model.add("size", values);
    }

    public void delete(Size s){
        model.delete("size", s.getId());
    }
}
