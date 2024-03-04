package mancala.domain;

import mancala.domain.exceptions.UnplayablePitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MancalaTest {
    public static void printBoard(AbstractPit firstPit) {
        String board = "\n     13 12 11 10 9  8\n     %02d %02d %02d %02d %02d %02d\n14 %02d                 %02d 7\n     %02d %02d %02d %02d %02d %02d\n     1  2  3  4  5  6";
        System.out.printf(board,
                firstPit.getPitAtDistance(12).getSeedCount(),
                firstPit.getPitAtDistance(11).getSeedCount(),
                firstPit.getPitAtDistance(10).getSeedCount(),
                firstPit.getPitAtDistance(9).getSeedCount(),
                firstPit.getPitAtDistance(8).getSeedCount(),
                firstPit.getPitAtDistance(7).getSeedCount(),
                firstPit.getPitAtDistance(13).getSeedCount(),
                firstPit.getPitAtDistance(6).getSeedCount(),
                firstPit.getSeedCount(),
                firstPit.getPitAtDistance(1).getSeedCount(),
                firstPit.getPitAtDistance(2).getSeedCount(),
                firstPit.getPitAtDistance(3).getSeedCount(),
                firstPit.getPitAtDistance(4).getSeedCount(),
                firstPit.getPitAtDistance(5).getSeedCount()
        );
    }

    @Test
    void playPit_test() {
        int[] seedCountArray = {
                1, 0, 0, 0, 0, 0,
                0,
                1, 0, 0, 0, 0, 0,
                0};
        IMancala mancala = new Mancala(seedCountArray);

        mancala.playPit(0);
        assertEquals(0, mancala.getStonesForPit(0));
        assertEquals(1, mancala.getStonesForPit(1));
    }

    @Test
    void getStonesForPit_test() {
        int[] seedCountArray = {
                1, 0, 0, 0, 0, 0,
                0,
                1, 0, 0, 0, 0, 0,
                0};
        IMancala mancala = new Mancala(seedCountArray);

        assertEquals(1, mancala.getStonesForPit(0));
    }

    @Test
    void isEndOfGame_test() {
        int[] seedCountArray = {
                1, 0, 0, 0, 0, 0,
                0,
                0, 0, 0, 0, 0, 0,
                0};
        IMancala mancala = new Mancala(seedCountArray);

        mancala.playPit(0);

        assertEquals(0, mancala.getStonesForPit(0));
        assertEquals(1, mancala.getStonesForPit(6));

        assertTrue(mancala.isEndOfGame());
    }

    @Test
    void getWinner_Player1_wins_test() {
        int[] seedCountArray = {
                1, 0, 0, 0, 0, 0,
                0,
                0, 0, 0, 0, 0, 0,
                0};
        IMancala mancala = new Mancala(seedCountArray);

        mancala.playPit(0);

        assertEquals(IMancala.Winner.PLAYER_1, mancala.getWinner());
    }

    @Test
    void getWinner_Player2_wins_test() {
        int[] seedCountArray = {
                1, 0, 0, 0, 0, 0,
                0,
                0, 0, 2, 0, 0, 0,
                0};
        IMancala mancala = new Mancala(seedCountArray);

        mancala.playPit(0);
        mancala.playPit(9);

        assertEquals(IMancala.Winner.PLAYER_2, mancala.getWinner());
    }

    @Test
    void getWinner_draw_test() {
        int[] seedCountArray = {
                0, 0, 0, 0, 0, 1,
                0,
                0, 0, 0, 0, 0, 1,
                0};
        IMancala mancala = new Mancala(seedCountArray);

        mancala.playPit(5);
        mancala.playPit(12);

        assertEquals(IMancala.Winner.DRAW, mancala.getWinner());
    }

    @Test
    void isPlayersTurn_its_player1s_turn_test() {
        IMancala mancala = new Mancala("hans", "jan");

        assertTrue(mancala.isPlayersTurn("hans"));
    }

    @Test
    void isPlayersTurn_its_player2s_turn_test() {
        IMancala mancala = new Mancala("hans", "jan");

        mancala.playPit(0);

        assertTrue(mancala.isPlayersTurn("jan"));
    }

}

