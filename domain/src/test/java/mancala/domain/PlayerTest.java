package mancala.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void player1IsActiveDefaultTest() {
        Pit firstPit = new Pit();

        assertTrue(firstPit.getPlayer().isActive());

    }

    @Test
    void OpponentIsInactiveDefaultTest() {
        Pit firstPit = new Pit();

        var player1 = firstPit.getPlayer();
        var player2 = player1.getOpponent();

        assertFalse(player2.isActive());

    }

    @Test
    void player1SwitchTurnPlayer1InactiveTest() {
        Pit firstPit = new Pit();

        var player1 = firstPit.getPlayer();

        player1.switchTurn();

        assertFalse(firstPit.getPlayer().isActive());

    }

    @Test
    void player1SwitchTurnOpponentActiveTest() {
        Pit firstPit = new Pit();

        var player1 = firstPit.getPlayer();
        var player2 = player1.getOpponent();

        player1.switchTurn();

        assertTrue(player2.isActive());

    }
}

