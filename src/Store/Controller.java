package Store;

import Store.toys.Toy;
import Store.toys.ToysList;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Controller {
    public ToysList addingToy(ToysList list) {
        int id = Integer.parseInt(prompt("Введите ID игрушки: "));
        if (!IDChecker(list, id)) {
            Toy newToy = new Toy(id, prompt("Введите название игркшки: "),
                    Integer.parseInt(prompt("Введите количество игрушек: ")), Integer.parseInt(prompt("Введите редкость игрушки: ")));
            list.addToy(newToy);
        } else throw new RuntimeException("Игрушка с таким ID существует");
        return list;
    }

    public ToysList countChanging(ToysList list) {
        HashMap<Integer, String> availableToys = availableToys(list);
        System.out.println("Список доступных игрушек: \n" + availableToys);
        int id = Integer.parseInt(prompt("Введите ID игрушки, у которой хотите изменить количество: "));
        if (IDChecker(list, id)) {
            if (!Objects.equals(prompt("Вы выбрали игрушку " + availableToys.containsKey(id) + ". Хотите изменить количество этой игрушки? (Y/N)").toLowerCase(), "y")) {
                if (Objects.equals(prompt("Хотите выбрать другую игрушку для изменения количества (Y), или выйти (N)?").toLowerCase(), "y")) {
                    countChanging(list);
                } else throw new RuntimeException("Операция изменения количества игрушек прервана");
            } else {
                for (Toy t : list.getList()) {
                    if (t.getId() == id) {
                        int newCunt = Integer.parseInt(prompt("Введите новое количество игрушек"));
                        if (newCunt > 0) {
                            t.setCount(newCunt);
                        } else {
                            throw new RuntimeException("Игрушек должно быть больше нуля. Если их нет - удалите игрушку.");
                        }
                    }
                }
            }
        } else {
            throw new RuntimeException("Игрушка с таким ID не существует");
        }
        return list;
    }

    public ToysList removingToy(ToysList list) {
        HashMap<Integer, String> availableToys = availableToys(list);
        System.out.println("Список доступных игрушек: \n" + availableToys);
        int id = Integer.parseInt(prompt("Введите ID игрушки, которую хотите удалить: "));
        if (IDChecker(list, id)) {
            if (!Objects.equals(prompt("Вы выбрали игрушку " + availableToys.containsKey(id) + ". Хотите удалить её? (Y/N)").toLowerCase(), "y")) {
                if (Objects.equals(prompt("Хотите выбрать другую игрушку для удаления (Y), или выйти (N)?").toLowerCase(), "y")) {
                    removingToy(list);
                } else throw new RuntimeException("Операция удаления прервана");
                for (Toy t : list.getList()) {
                    if (t.getId() == id) {
                        list.deleteToy(t);
                    }
                }
            }
        } else throw new RuntimeException("Игрушка с таким ID не существует");
        return list;
    }

    public ToysList valueChanging(ToysList list) {
        HashMap<Integer, String> availableToys = availableToys(list);
        System.out.println("Список доступных игрушек: \n" + availableToys);
        int id = Integer.parseInt(prompt("Введите ID игрушки, у которой хотите изменить редкость: "));
        if (IDChecker(list, id)) {
            if (!Objects.equals(prompt("Вы выбрали игрушку " + availableToys.containsKey(id) + ". Хотите изменить редкость этой игрушки? (Y/N)").toLowerCase(), "y")) {
                if (Objects.equals(prompt("Хотите выбрать другую игрушку для изменения редкоти (Y), или выйти (N)?").toLowerCase(), "y")) {
                    countChanging(list);
                } else throw new RuntimeException("Операция изменения редкости игрушек прервана");
                for (Toy t : list.getList()) {
                    if (t.getId() == id) {
                        t.setValue(Integer.parseInt(prompt("Введите новое значение редкости: 1 - обычная, 2 - необычная, 3 - редкая, 4 - уникальная")));
                    }
                }
            } else throw new RuntimeException("Игрушка с таким ID не существует");

        }
        return list;
    }


    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    private boolean IDChecker(ToysList list, int id) {
        for (Toy t : list.getList()) {
            if (t.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private HashMap<Integer, String> availableToys(ToysList list) {
        HashMap<Integer, String> availableToys = new HashMap<>();
        for (Toy t : list.getList()) {
            availableToys.put(t.getId(), t.getName());
        }
        return availableToys;
    }
}


