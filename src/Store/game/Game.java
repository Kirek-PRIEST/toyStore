package Store.game;

import Store.Commands;
import Store.operations.Operations;
import Store.toys.ToysList;

import java.util.HashMap;
import java.util.LinkedList;

public class Game implements Operations {


    @Override
    public ToysList operations(ToysList list) {
        ToyMachine toyMachine = new ToyMachine(list);
        toyMachine.game();
        return list;
    }
}
