package Store;

import Store.operations.Operations;
import Store.toys.ToysList;

import java.util.HashMap;

public class ToysWorker  {



    public void actions(ToysList list) {
        HashMap<Integer, Operations> map = Commands.commands();
        Operations operations = map.get(1);
        operations.operations(list);
    }
}
