package Store.operations;

import Store.toys.Toy;
import Store.toys.ToysList;

public class RemovingToy implements Operations {
    @Override
    public ToysList operations(ToysList list, int... data) {
        for (Toy t : list.getList()){
            if (t.getId() == data[0]){
                list.deleteToy(t);
            }
            else throw new RuntimeException("Игрушка с таким ID не существует");

        }
        return list;
    }
}
