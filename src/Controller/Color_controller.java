package Controller;

import Entity.Color;
import Model.Color_model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Color_controller {
    private Color_model model;

    public Color_controller(Color_model model){
        this.model = model;
    }

    public LinkedList<Color> getAllColors(){
        LinkedList<Color> result = new LinkedList<Color>();
        for (Object o : model.getAll("Color")){
            result.add((Color) o);
        }
        return result;
    }

    public void edit(Color col){
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", String.valueOf(col.getId()));
        values.put("name", col.getName());
        model.edit("color", values);
    }

    /**
     * Crée en base la couleur donnée en paramètre
     * @param col
     */
    public void addColor(Color col){
        HashMap<String, Object> values = new HashMap<>();
        values.put("name", col.getName());
        model.add("color", values);
    }

    public void delete(Color col){
        model.delete("color", col.getId());
    }
}
