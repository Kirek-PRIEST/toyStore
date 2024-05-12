package Store.operations;

import Store.toys.Toy;
import Store.toys.ToysList;

public class CountChanging implements Operations {
    @Override
    public ToysList operations(ToysList list, int... data) {
        if (list.containsId(data[0])) {
            for (Toy t : list.getList()) {
                if (t.getId() == data[0]) {
                    if (t.getCount() + data[1] > 0) {
                        t.setCount(t.getCount() + data[1]);
                    } else if (t.getCount() + data[1] == 0) {
                        list.deleteToy(t);
                        System.out.println("Игрушка " + t.getName() + "с id " + t.getId() + "закончилась");
                    } else {
                        throw new RuntimeException("Игрушек не хватает");
                    }
                }
                }
            }else {throw new RuntimeException("Игрушка с таким ID не существует");

        }
        return list;
    }
}