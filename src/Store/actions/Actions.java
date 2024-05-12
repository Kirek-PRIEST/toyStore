package Store.actions;

import Store.toys.ToysList;
import Store.operations.Operations;

public class Actions {
    Operations operations;

    public ToysList action(ToysList list, int... data) {
        operations.operations(list, data);
        return list;
    }
}
