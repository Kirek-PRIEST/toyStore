package Store.game;
import Store.operations.Operations;
import Store.toys.ToysList;

public class Game implements Operations {


    @Override
    public ToysList operations(ToysList list) {
        ToyMachine toyMachine = new ToyMachine(list);
        toyMachine.game();
        return list;
    }
}
