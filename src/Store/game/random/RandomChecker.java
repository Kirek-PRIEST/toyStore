package Store.game.random;

import java.util.TreeMap;

public class RandomChecker {


    public TreeMap<Integer, Integer> getMap(int count) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Randomizer randomizer = new Randomizer();
        for (int i = 0; i < count; i++) {
            int randomResult = randomizer.randomizer();
            if (map.containsKey(randomResult)){
            map.put(randomResult, map.get(randomResult) + 1);
        }else {
                map.put(randomResult, 1);
            }

        }

        return map;
    }

}
