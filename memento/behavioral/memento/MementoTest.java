package behavioral.memento;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class MementoTest extends Assert {

    @Test
    public void testMemento() throws FileNotFoundException {
        behavioral.memento.GameXO gameXO = new behavioral.memento.GameXO();
        behavioral.memento.GameStorage gs1 = new behavioral.memento.GameStorage(gameXO);
        gs1.save("xo_game.dat");

        // ...
        gs1.load("xo_game.dat");


    }

}
