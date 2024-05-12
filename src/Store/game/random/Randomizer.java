package Store.game.random;

import java.util.Random;

public class Randomizer {
    private int collation(int income){
        if (income <51 ){
            return 1;
        } else if (income < 76) {
            return 2;
        } else if (income < 96) {
            return 3;
        }
        else return 4;

    }
    private int random(){
        Random rnd = new Random();
        return rnd.nextInt(101);
    }
    public int randomizer(){
        return collation(random());
    }
}
