package Store;

import Store.actions.*;
import Store.toys.ToysList;

public class Controller {

    public void addingToy(ToysList toysList, int id, int count, int value) {
        Actions add = new AddToy();
        add.action(toysList, id, count, value);

    }

    public void removingToy(ToysList toysList, int id) {
        Actions removingToy = new RemoveToy();
        removingToy.action(toysList, id);
    }

    public void countChanging(ToysList toysList, int id, int count){
        Actions changeCount = new CountChange();
        changeCount.action(toysList, id, count);
    }
    public void valueChanging (ToysList toysList, int id, int value){
        Actions changeValue = new ValueChange();
        changeValue.action(toysList, id, value);
    }

}
