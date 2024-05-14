package Store.operations;

import Store.toys.ToysList;

public class PrintToysList implements Operations{
    @Override
    public ToysList operations(ToysList list) {
        System.out.println(list);
        return list;
    }
}
