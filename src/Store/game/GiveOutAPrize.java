package Store.game;

import Store.game.GameActions;
import Store.game.GameOptions;
import Store.operations.Operations;
import Store.toys.ToysList;

import java.util.LinkedList;

public class GiveOutAPrize implements GameOptions {


    @Override
    public void gameOption(ToysList toysList, LinkedList<String> toGiveOutList) {
        GameActions actions = new GameActions();
        actions.giveOutPrize(toGiveOutList);
    }


}
