package Store.game;

import Store.game.random.Randomizer;
import Store.toys.Toy;
import Store.toys.ToysList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class GameActions {
    public LinkedList<String> startGame(ToysList toysList, LinkedList<String> toGiveOut) {
        ArrayList<Toy> winnersList;

        Randomizer r = new Randomizer();
            winnersList = divisionOfRarity(toysList, r.randomizer());
            Toy winner = winner(winnersList);
            toGiveOut.add(winner.getName());
            System.out.println("Выиграла игрушка " + winner.getName());
            winner.setCount(winner.getCount() - 1);

        return toGiveOut;
    }

    public LinkedList<String> giveOutPrize(LinkedList<String> forGiveOut) {
        try {
            FileWriter fr = new FileWriter("Prizes.txt");
            fr.flush();
            fr.append(forGiveOut.removeFirst()).append("\n");
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
