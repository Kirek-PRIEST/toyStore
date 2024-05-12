package Store;

import Store.game.Game;
import Store.toys.ToysList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Starter {
    Map<Integer, Controller> map = new HashMap<>();
    Controller controller = new Controller();
    ToysList list = new ToysList();
    Game game = new Game();

    public void run() {
        controller.addingToy(list, 1, 50, 1);
        controller.addingToy(list, 2, 50, 1);
        controller.addingToy(list, 3, 50, 1);
        controller.addingToy(list, 4, 50, 1);
        controller.addingToy(list, 5, 50, 1);
        controller.addingToy(list, 6, 25, 2);
        controller.addingToy(list, 7, 10, 3);
        controller.addingToy(list, 8, 5, 4);

        //controller.valueChanging(list, 1, 50);
        //controller.countChanging(list, 1, 1);
        //controller.removingToy(list, 1);
        System.out.println(list);
        game.game(list);
        System.out.println("Список игрушек на выдачу" + game.game(list));
        System.out.println();
    }

    String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
