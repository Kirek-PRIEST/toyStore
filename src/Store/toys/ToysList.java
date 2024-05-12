package Store.toys;

import java.util.LinkedList;
import java.util.List;

public class ToysList {
    private List<Toy> listOfToys = new LinkedList<>();


    public void addToy(Toy toy){
        listOfToys.add(toy);
    }
    public void deleteToy(Toy toy){
        listOfToys.remove(toy);
    }
    public int getSize (){
        return listOfToys.size();
    }
    public List<Toy> getList (){
        return listOfToys;
    }
    public boolean containsId(int id){
        for (Toy t : listOfToys){
            if (t.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (!listOfToys.isEmpty()) {
            return "Список игрушек:\n" +
                    listOfToys +
                    '\n';
        }
        return "Cписок игрушек пуст";
    }
}
