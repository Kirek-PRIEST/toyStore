package Store;

import Store.game.Game;
import Store.operations.*;
import Store.toys.ToysList;

import java.util.HashMap;
import java.util.Scanner;

public class Starter {

    Controller controller = new Controller();
    ToysList list = new ToysList();
    Game game = new Game();

    public void run() {
        HashMap<Integer, Operations> map = Commands.commands();
        Operations operations = map.get(2);
        operations.operations(list);
        System.out.println(list);

//        controller.addingToy(list, 1, 50, 1);
//        controller.addingToy(list, 2, 50, 1);
//        controller.addingToy(list, 3, 50, 1);
//        controller.addingToy(list, 4, 50, 1);
//        controller.addingToy(list, 5, 50, 1);
//        controller.addingToy(list, 6, 25, 2);
//        controller.addingToy(list, 7, 10, 3);
//        controller.addingToy(list, 8, 5, 4);

        //controller.valueChanging(list, 1, 50);
        //controller.countChanging(list, 1, 1);
        //controller.removingToy(list, 1);

    }

    String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
