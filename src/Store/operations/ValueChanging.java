package Store.operations;

import Store.toys.ToysList;

public class ValueChanging implements Operations{
    @Override
    public ToysList operations(ToysList list) {
        Controller testController = new Controller();
        return testController.valueChanging(list);
    }
}
