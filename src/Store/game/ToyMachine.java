package Store.game;

import Store.Commands;
import Store.operations.Operations;
import Store.toys.ToysList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ToyMachine {
    ToysList toysList;
    private LinkedList<String> toGiveOut = new LinkedList<>();
    HashMap<Integer, GameOptions> gameCommands = Commands.gameCommands();
    private boolean isExit = false;

    public ToyMachine(ToysList toysList) {
        this.toysList = toysList;
    }

    public void game() {
        try {
            while (true) {
                while (!isExit) {
                    int choice = Integer.parseInt(prompt("Список доступных действий:\n" +
                            "1 = разыграть игрушку\n" +
                            "2 = выдать игрушку\n" +
                            "3 = вернуться\n"));
                    if (choice > 0 && choice < 4) {
                        if (choice == 3) {
                            return;
                        } else {
                            GameOptions gameOptions = gameCommands.get(choice);
                            gameOptions.gameOption(toysList, toGiveOut);
                        }
                    } else {
                        System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
                        game();
                    }

                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
            game();
        }
    }

    String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }


}
