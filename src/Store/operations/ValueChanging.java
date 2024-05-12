package Store.operations;

import Store.toys.Toy;
import Store.toys.ToysList;

public class ValueChanging implements Operations {
    @Override
    public ToysList operations(ToysList list, int... data) {
        if (list.containsId(data[0])) {
            for (Toy t : list.getList()) {
                if (t.getId() == data[0]) {
                    t.setValue(data[1]);
                }
            }
        } else throw new RuntimeException("Игрушка с таким ID не существует");
        return list;
    }
}
