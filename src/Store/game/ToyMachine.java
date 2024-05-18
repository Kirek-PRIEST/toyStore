package Store.game;

import Store.Commands;
import Store.toys.Toy;
import Store.toys.ToysList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToyMachine {
    ToysList toysList;
    private LinkedList<String> toGiveOut = new LinkedList<>();
    HashMap<Integer, GameOptions> gameCommands = Commands.gameCommands();
    ArrayList<ToysList> setOfToys = new ArrayList<>();


    public ToyMachine(ToysList toysList) {
        this.toysList = toysList;
    }

    public void game() {
       toysByRarity(toysList);
        try {
            while (true) {
                if (toysList.getList().isEmpty()) {
                    System.out.println("Игра недоступна. Отсутствуют игрушки в автомате.");
                    return;
                }
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

    private void toysByRarity(ToysList list) {
        ToysList common = new ToysList();
        ToysList uncommon = new ToysList();
        ToysList rare = new ToysList();
        ToysList unic = new ToysList();
        for (Toy t : list.getList()) {
            if (t.getValue() == 1) {
                common.addToy(t);
            }
            if (t.getValue() == 2) {
                uncommon.addToy(t);
            }
            if (t.getValue() == 3) {
                rare.addToy(t);
            }
            if (t.getValue() == 4) {
                unic.addToy(t);
            }
            setOfToys.add(common);
            setOfToys.add(uncommon);
            setOfToys.add(rare);
            setOfToys.add(unic);
        }
    }


}
