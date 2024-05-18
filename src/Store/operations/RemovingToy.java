package Store.operations;

import Store.toys.ToysList;

public class RemovingToy implements Operations{
    @Override
    public ToysList operations(ToysList list) {
        Controller testController = new Controller();
        return testController.removingToy(list);
    }
}
