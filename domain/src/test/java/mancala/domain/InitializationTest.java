package mancala.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InitializationTest {
    @Test
    void generateNewPitWithNextPit() {
        AbstractPit firstPit = new Pit();

        assertInstanceOf(Pit.class, firstPit.getNextPit());
    }

    @Test
    void generateNewPitCheckSixthPit() {
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 5; i++) { // pit
            resultPit = resultPit.getNextPit();
        }

        assertInstanceOf(Pit.class, resultPit);
    }

    @Test
    void generateSeventhIPitShouldBeKahluaTest() {
        AbstractPit firstPit = new Pit(); // pit 0

        AbstractPit nextPit = firstPit; // pit 1
        for (int i = 0; i < 6; i++) {
            nextPit = nextPit.getNextPit();
        }

        assertInstanceOf(Kahlua.class, nextPit);
    }

    @Test
    void generate13thIPitShouldBePitTest() {
        AbstractPit firstPit = new Pit(); // pit 0

        AbstractPit retultPit = firstPit; // pit 1
        for (int i = 0; i < 12; i++) {
            retultPit = retultPit.getNextPit();
        }

        assertInstanceOf(Pit.class, retultPit);
    }

    @Test
    void generate14thIPitShouldBeKahluaTest() {
        AbstractPit firstPit = new Pit(); // pit 0

        AbstractPit resultPit = firstPit; // pit 1
        for (int i = 0; i < 13; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertInstanceOf(Kahlua.class, resultPit);
    }

    @Test
    void generate15thIPitShouldReferToFirstPitTest() {
        AbstractPit firstPit = new Pit(); // pit 0

        AbstractPit resultPit = firstPit; // pit 1
        for (int i = 0; i < 14; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertSame(firstPit, resultPit);
    }

    @Test
    void initializePlayerWithOpponent() {
        Player player1 = new Player();
        Player player2 = player1.getOpponent();

        assertInstanceOf(Player.class, player2);

    }

    @Test
    void initializePlayerWithPlayerActive() {
        Player player1 = new Player();

        assertTrue(player1.isActive());

    }

    @Test
    void initializePlayerWithOpponentInactive() {
        Player player1 = new Player();
        Player player2 = player1.getOpponent();

        assertFalse(player2.isActive());

    }

    @Test
    void initializePitsFirstPitHasPlayer() {
        AbstractPit firstPit = new Pit();

        assertInstanceOf(Player.class, firstPit.getPlayer());

    }

    @Test
    void initializePitsFifthPitHasPlayer() {
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 4; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertInstanceOf(Player.class, resultPit.getPlayer());

    }

    @Test
    void initializePitsKahluaHasPlayer() {
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 6; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertInstanceOf(Player.class, resultPit.getPlayer());

    }

    @Test
    void initializePitsFirstKahluaHasSamePlayer() {
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 6; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertSame(firstPit.getPlayer(), resultPit.getPlayer());

    }

    @Test
    void initializePitsEightPitHasDifferentPlayer() {
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 7; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertNotSame(firstPit.getPlayer(), resultPit.getPlayer());

    }

    @Test
    void initializePitsEightPitAndSecondKahluaHaveSamePlayer() {
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 7; i++) {
            resultPit = resultPit.getNextPit();
        }
        AbstractPit resultKahlua = firstPit;
        for (int i = 0; i < 13; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertSame(resultPit.getPlayer(), resultKahlua.getPlayer());

    }

    @Test
    void initializePitsCheckSeedCountFirstPitTest(){
        AbstractPit firstPit = new Pit();

        assertEquals(4,firstPit.getSeedCount());
    }

    @Test
    void initializePitsCheckSeedCountSixthPitTest(){
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 5; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertEquals(4,resultPit.getSeedCount());
    }

    @Test
    void initializePitsCheckSeedCountFirstKahluaTest(){
        AbstractPit firstPit = new Pit();

        AbstractPit resultKahlua = firstPit;
        for (int i = 0; i < 6; i++) {
            resultKahlua = resultKahlua.getNextPit();
        }

        assertEquals(0,resultKahlua.getSeedCount());
    }

    @Test
    void initializePitsCheckSeedCountEighthPitTest(){
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 7; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertEquals(4,resultPit.getSeedCount());
    }

    @Test
    void initializePitsCheckSeedCount13thPitTest(){
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 12; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertEquals(4,resultPit.getSeedCount());
    }

    @Test
    void initializePitsCheckSeedCountSecondKahluaTest(){
        AbstractPit firstPit = new Pit();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 13; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertEquals(0,resultPit.getSeedCount());
    }

}
