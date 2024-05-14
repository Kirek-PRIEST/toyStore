package Store.game;

import Store.toys.ToysList;

import java.util.LinkedList;

public interface GameOptions {
    void gameOption(ToysList toysList, LinkedList<String> toGiveOutList);
}
