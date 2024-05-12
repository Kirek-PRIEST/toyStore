package Store.operations;

import Store.toys.Toy;
import Store.toys.ToysList;

import java.util.Scanner;

public class AddingToy implements Operations {


    @Override
    public ToysList operations(ToysList list, int... data) {

            if (list.getSize() == 0| !(list.containsId(data[0]))) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Введите название игркшки");
                Toy newToy = new Toy(data[0], sc.nextLine(), data[1], data[2]);
                list.addToy(newToy);
            } else throw new RuntimeException("Игрушка с таким ID существует");
        return list;
    }

}
