package Store;

import Store.operations.*;

import java.util.HashMap;
import java.util.Map;

public class Commands {
    public static HashMap<Integer, Operations> commands(){
        HashMap<Integer, Operations> map = new HashMap<>();
        map.put(1, new AddingToy());
        map.put(2, new RemovingToy());
        map.put(3, new CountChanging());
        map.put(4, new ValueChanging());
        return map;
    }
}
