package Controller;

import Entity.Category;
import Model.Category_model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Finelam on 19/01/2016.
 */
public class Category_controller {

    private Category_model model;

    public Category_controller(Category_model model){
        this.model = model;
    }

    /**
     * Récupère les objets en base puis renvoie une LinkedList de Category
     * @return
     */
    public LinkedList<Category> getAllCategories(){
        LinkedList<Category> result = new LinkedList<Category>();
        for (Object o : model.getAll("Category")) {
            result.add((Category) o);
        }
        return result;
    }

    /**
     * Modifie l'entité passée en paramètre
     * @param cat
     */
    public void edit(Category cat){
        String table = cat.getClass().getSimpleName().toLowerCase();
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", cat.getId());
        values.put("name", cat.getName());
        values.put("enabled", cat.isEnabled() ? 1 : 0);
        model.edit(table, values);
    }

    /**
     * Crée en base la catégorie donnée en paramètre
     * @param cat
     */
    public void addCategory(Category cat){
        HashMap<String, Object> values = new HashMap<>();
        values.put("name", cat.getName());
        values.put("enabled", cat.isEnabled());
        model.add("category", values);
    }

    public void delete(Category cat){
        model.delete("category", cat.getId());
    }

    /**
     * Récupère l'objet en base puis renvoie la Category demandée
     * @param id
     * @return
     */
    public Category get(int id){
        return (Category)model.find("Category", id);
    }
}
