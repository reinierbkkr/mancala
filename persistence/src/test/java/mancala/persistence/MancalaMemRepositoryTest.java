package mancala.persistence;

import mancala.domain.IMancala;
import mancala.domain.Mancala;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MancalaMemRepositoryTest {
    @Test
    void repo_test(){
        IMancalaRepository repo = new MancalaMemRepository();

        repo.save("1",new Mancala("a","b"));
        IMancala mancala = repo.get("1");

        assertFalse(mancala.isPlayersTurn("b"));

    }

}
