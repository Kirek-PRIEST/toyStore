package Store.game;

import Store.toys.Toy;

import java.util.ArrayList;
import java.util.List;

public class PrizeList {

    private List<Toy> listOfPrizes = new ArrayList<>();
    public void addToy(Toy toy){
        listOfPrizes.add(toy);
    }
    public void deleteToy(Toy toy){
        listOfPrizes.remove(toy);
    }
    public int getSize (){
        return listOfPrizes.size();
    }
    public List<Toy> getList (){
        return listOfPrizes;
    }


}
