package Store.game;

import Store.game.random.Randomizer;
import Store.toys.Toy;
import Store.toys.ToysList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.time.LocalDateTime;

public class GameActions {
    public LinkedList<String> startGame(ToysList toysList, LinkedList<String> toGiveOut) {
        ArrayList<Toy> winnersList;

        Randomizer r = new Randomizer();
            winnersList = divisionOfRarity(toysList, r.randomizer());
            Toy winner = winner(winnersList);
            toGiveOut.add(winner.getName());
            System.out.println(" = Выиграла игрушка " + winner.getName() + "\n");
        System.out.println("Список выиграннызх игрушек:\n" + toGiveOut);
            winner.setCount(winner.getCount() - 1);
            if (winner.getValue() == 0){
                toysList.deleteToy(winner);
            }

        return toGiveOut;
    }

    public LinkedList<String> giveOutPrize(LinkedList<String> forGiveOut) {
        if (forGiveOut.isEmpty()){
            System.out.println("Вы ешё не выиграли ни одной игрушки.");
            return forGiveOut;
        }
        LocalDateTime dateStamp = LocalDateTime.now();
        try {
            FileWriter fr = new FileWriter("Prizes.txt", true);
            fr.append(dateStamp.toString()).append(" - Игрушка: ").append(forGiveOut.removeFirst()).append("\n");
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Список выигранныз игрушек:\n" + forGiveOut);
        return forGiveOut;
    }

    private Toy winner(ArrayList<Toy> winnersList) {
        int winner = (int) (Math.random() * winnersList.size());
        return winnersList.get(winner);
    }

    private ArrayList<Toy> divisionOfRarity(ToysList list, int resultOfRarity) {
        ArrayList<Toy> winnersList = new ArrayList<>();

        if (resultOfRarity == 1) {
            for (Toy t : list.getList()) {
                if (t.getValue() == 1) {
                    winnersList.add(t);
                }
            }
        }
        if (resultOfRarity == 2) {
            for (Toy t : list.getList()) {
                if (t.getValue() == 2) {
                    winnersList.add(t);
                }
            }
        }
        if (resultOfRarity == 3) {
            for (Toy t : list.getList()) {
                if (t.getValue() == 3) {
                    winnersList.add(t);
                }

            }
        }
        if (resultOfRarity == 4) {
            for (Toy t : list.getList()) {
                if (t.getValue() == 4) {
                    winnersList.add(t);
                }
            }
        }
        return winnersList;
    }
}
