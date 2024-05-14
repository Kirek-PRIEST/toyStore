package Store.game;

import Store.toys.ToysList;

import java.util.LinkedList;

public class StartGame implements GameOptions{

    @Override
    public void gameOption(ToysList toysList, LinkedList<String> toGiveOutList) {
        GameActions actions = new GameActions();
        actions.startGame(toysList, toGiveOutList);
    }
}
