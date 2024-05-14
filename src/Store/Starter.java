package Store;

import Store.game.Game;
import Store.operations.*;
import Store.toys.ToysList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Starter {


    ToysList list = new ToysList();
    LinkedList<String> toGiveOut = new LinkedList<>();
    private boolean isExit = false;
    HashMap<Integer, Operations> map = Commands.commands();

    public void run() {
        try {
            while (true) {
                while (!isExit) {
                    int choice = Integer.parseInt(prompt("Список доступных действий:\n" +
                            "1 = создать игрушку\n" +
                            "2 = удалить игрушку\n" +
                            "3 = изменить количество игрушек\n" +
                            "4 = изменить редкость игрушек\n" +
                            "5 = печать списка игрушек\n" +
                            "6 = Игра\n" +
                            "7 = выход из программы"));
                    if (choice > 0 && choice < 8) {
                        Operations operations = map.get(choice);
                        operations.operations(list);
                    }else {
                        System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
                        run();
                    }
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
            run();
        }

    }

    String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

}
