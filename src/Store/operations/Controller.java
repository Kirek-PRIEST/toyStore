package Store.operations;

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
        } else {
            System.out.println("Игрушка с таким ID существует");
            availableToys(list);
        }

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
                } else {
                    System.out.println("Изменение количества игрущек прервано. Выберите новую прерацию.");
                    return list;
                }
            } else {
                for (Toy t : list.getList()) {
                    if (t.getId() == id) {
                        int newCunt = Integer.parseInt(prompt("Введите новое количество игрушек"));
                        if (newCunt > 0) {
                            t.setCount(newCunt);
                        } else {
                            System.out.println("Игрушка с таким ID не существует");
                            if (Objects.equals(prompt("Хотите продолжить изменение количества игрушек (Y), или выйти (N)?").toLowerCase(), "y")) {
                                countChanging(list);
                            } else return list;
                        }
                    }
                }
            }
        } else {
            System.out.println("Игрушка с таким ID не существует");
            if (Objects.equals(prompt("Хотите продолжить изменение количества игрушек (Y), или выйти (N)?").toLowerCase(), "y")) {
                countChanging(list);
            } else return list;
        }
        return list;
    }

    public ToysList removingToy(ToysList list) {
        HashMap<Integer, String> availableToys = availableToys(list);
        System.out.println("Список доступных игрушек: \n" + availableToys);
        int id = Integer.parseInt(prompt("Введите ID игрушки, которую хотите удалить: "));
        if (IDChecker(list, id)) {
            String choiceToy = prompt("Вы выбрали игрушку " + availableToys.get(id) + ". Хотите удалить её? (Y/N)");
            if (yesOrNo(choiceToy)) {
                String anotherToy = prompt("Хотите выбрать другую игрушку для удаления (Y), или выйти (N)?").toLowerCase();
                if (yesOrNo(anotherToy)) {
                    removingToy(list);
                } else return list;
                for (Toy t : list.getList()) {
                    if (t.getId() == id) {
                        list.deleteToy(t);
                    }
                }
            }
        } else {
            System.out.println("Игрушка с таким ID не существует");
            String returnRemoving = prompt("Хотите продолжить изменение количества игрушек (Y), или выйти (N)?").toLowerCase();
            if (yesOrNo(returnRemoving)) {
                removingToy(list);
            } else return list;

        }
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
                } else {
                    throw new RuntimeException("Операция изменения редкости игрушек прервана");
                }
                try {
                    for (Toy t : list.getList()) {
                        if (t.getId() == id) {
                            int newValue = Integer.parseInt(prompt("Введите новое значение редкости: 1 - обычная, 2 - необычная, 3 - редкая, 4 - уникальная"));
                            if (newValue > 0 && newValue < 5) {
                                t.setValue(newValue);
                            }else {
                                System.out.println("Введено некорректное значение редкости, повторите снова");
                                valueChanging(list);
                            }
                        }
                    }
                } catch (NumberFormatException e){
                    System.out.println("Введено некорректное значение редкости, повторите снова");
                    valueChanging(list);
                }

            } else System.out.println("Игрушка с таким ID не существует");
            {
                if (Objects.equals(prompt("Хотите продолжить изменение количества игрушек (Y), или выйти (N)?").toLowerCase(), "y")) {
                    valueChanging(list);
                } else return list;
            }
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

    private boolean yesOrNo(String income){
        if (income.equals("y") || Objects.equals(income, "n")){
            return income.equals("y");
        }
        return false;
    }
}


