package Store.operations;

import Store.Controller;
import Store.toys.ToysList;

public class AddingToy implements Operations{
    @Override
    public ToysList operations(ToysList list) {
        Controller testController = new Controller();
        return testController.addingToy(list);
    }
}
