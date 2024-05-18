package Store.operations;

import Store.operations.Operations;
import Store.toys.ToysList;

public class EndProgram implements Operations {

    @Override
    public ToysList operations(ToysList list) {
        System.out.println("Спасибо за использование программы");
        System.exit(0);
        return null;
    }
}
