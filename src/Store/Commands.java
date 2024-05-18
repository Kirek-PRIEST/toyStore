package Store;

import Store.game.Game;
import Store.game.GameOptions;
import Store.game.GiveOutAPrize;
import Store.game.StartGame;
import Store.operations.*;
import Store.operations.EndProgram;

import java.util.HashMap;

public class Commands {
    public static HashMap<Integer, Object> startMenu(){
        HashMap<Integer,Object> map = new HashMap<>();
        map.put(1, new ToysWorker());
        map.put(2, new Game());
        map.put(3, new EndProgram());
        return map;
    }
    public static HashMap<Integer, Operations> commands(){
        HashMap<Integer, Operations> map = new HashMap<>();
        map.put(1, new AddingToy());
        map.put(2, new RemovingToy());
        map.put(3, new CountChanging());
        map.put(4, new ValueChanging());
        map.put(5, new PrintToysList());
        map.put(6, new Game());
        map.put(7, new EndProgram());


        return map;
    }
    public static HashMap<Integer, GameOptions> gameCommands(){
        HashMap<Integer, GameOptions> map = new HashMap<>();
        map.put(1, new StartGame());
        map.put(2, new GiveOutAPrize());
        return map;
    }
}
