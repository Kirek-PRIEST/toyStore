package Store.game;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class GiveOutAPrize {
    public void toGiveOut(LinkedList<String> forGiveOut){

        try {
            FileWriter fr = new FileWriter("Prizes.txt");
            fr.flush();
            fr.append(forGiveOut.removeFirst()).append("\n");
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
