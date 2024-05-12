package Store.game;

import Store.game.random.Randomizer;
import Store.toys.Toy;
import Store.toys.ToysList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Game {
    ToysList toysList;
    PrizeList list;
    LinkedList<String> toGiveOut = new LinkedList<>();
    ArrayList<Toy> winnersList = new ArrayList<>();


    public LinkedList<String> game(ToysList listForGame) {
        Randomizer r = new Randomizer();
        for (int i =0; i < 100; i++) {
            winnersList = divisionOfRarity(listForGame, r.randomizer());
            System.out.println("Список для победителей" +  winnersList);
            Toy winner = winner(winnersList);
            toGiveOut.add(winner.getName());
            System.out.println("Выиграла игрушка " + winner.getName());
            winner.setCount(winner.getCount() - 1);
        }

        return toGiveOut;
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

    private Toy winner(ArrayList<Toy> winnersList) {

       // Random random = new Random();
        int winner = (int) (Math.random() * winnersList.size());//random.nextInt(winnersList.size() + 1);

        return winnersList.get(winner);
    }

}
