package mancala.domain;

import mancala.domain.exceptions.UnplayablePitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PitTest {
    private static int getTotalSeeds(Pit pit1) {
        int sum = pit1.getSeedCount();
        for (int i = 1; i < 14; i++) {
            sum += pit1.getPitAtDistance(i).getSeedCount();
        }
        return sum;
    }

    public static void printBoard(AbstractPit firstPit) {
        String board = """
                     13 12 11 10 9  8
                     %02d %02d %02d %02d %02d %02d
                14 %02d                 %02d 7
                     %02d %02d %02d %02d %02d %02d
                     1  2  3  4  5  6
                """;
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
    void getPitAtDistance1FromFirstPit() {
        Pit firstPit = new Pit();

        AbstractPit secondPit = firstPit.getNextPit();

        assertSame(secondPit, firstPit.getPitAtDistance(1));

    }

    @Test
    void getPitAtDistance2FromFirstPit() {
        Pit firstPit = new Pit();

        AbstractPit expectedPit = firstPit;
        for (int i = 0; i < 2; i++) {
            expectedPit = expectedPit.getNextPit();
        }

        assertSame(expectedPit, firstPit.getPitAtDistance(2));

    }

    @Test
    void getPitAtDistance6FromFirstPit() {
        Pit firstPit = new Pit();

        AbstractPit expectedPit = firstPit;
        for (int i = 0; i < 6; i++) {
            expectedPit = expectedPit.getNextPit();
        }

        assertSame(expectedPit, firstPit.getPitAtDistance(6));

    }

    @Test
    void getPitAtDistance7FromFirstPit() {
        Pit firstPit = new Pit();

        AbstractPit expectedPit = firstPit;
        for (int i = 0; i < 7; i++) {
            expectedPit = expectedPit.getNextPit();
        }

        assertSame(expectedPit, firstPit.getPitAtDistance(7));

    }

    @Test
    void getPitAtDistance14FromFirstPit() {
        Pit firstPit = new Pit();

        assertSame(firstPit, firstPit.getPitAtDistance(14));

    }

//    @Test
//    void getDistanceToNextKahluaFromSixthPitTest() {
//        Pit firstPit = new Pit();
//        Pit sixthPit = (Pit) firstPit.getPitAtDistance(5);
//
//        assertEquals(1, sixthPit.getDistanceToNextKahlua());
//    }
//
//    @Test
//    void getDistanceToNextKahluaFromFifthPitTest() {
//        Pit firstPit = new Pit();
//        Pit fifthPit = (Pit) firstPit.getPitAtDistance(4);
//
//        assertEquals(2, fifthPit.getDistanceToNextKahlua());
//    }
//
//    @Test
//    void getDistanceToNextKahluaFromFirstPitTest() {
//        Pit firstPit = new Pit();
//
//        assertEquals(6, firstPit.getDistanceToNextKahlua());
//    }

//    @Test
//    void getOppositePitFromSixthPitTest() {
//        Pit firstPit = new Pit();
//        Pit sixthPit = (Pit) firstPit.getPitAtDistance(5);
//
//        assertSame(sixthPit.getPitAtDistance(2), sixthPit.getOppositePit());
//
//    }
//
//    @Test
//    void getOppositePitFromFirstPitTest() {
//        Pit firstPit = new Pit();
//        Pit oppositePit = (Pit) firstPit.getPitAtDistance(12);
//
//        assertSame(oppositePit, firstPit.getOppositePit());
//
//    }

//    @Test
//    void SendSeedsToOpponentsKahluaFromSixthPitTest() {
//        Pit firstPit = new Pit();
//        Pit sixthPit = (Pit) firstPit.getPitAtDistance(5);
//        IPit kahlua = firstPit.getPitAtDistance(13);
//        sixthPit.sendSeedsToOpponentsKahlua();
//
//        assertEquals(4, kahlua.getSeedCount());
//
//    }

//    @Test
//    void SendSeedsToOpponentsKahluaFromSixthPitCheckIsEmptyTest() {
//        Pit firstPit = new Pit();
//        Pit sixthPit = (Pit) firstPit.getPitAtDistance(5);
//        sixthPit.sendSeedsToOpponentsKahlua();
//
//        assertTrue(sixthPit.getSeedCount()==0);
//    }

//    @Test
//    void SendSeedsToOpponentsKahluaFromFirstPitTest() {
//        Pit firstPit = new Pit();
//        IPit kahlua = firstPit.getPitAtDistance(13);
//        firstPit.sendSeedsToOpponentsKahlua();
//
//        assertEquals(4, kahlua.getSeedCount());
//
//    }

//    @Test
//    void SendSeedsToOpponentsKahluaFromFirstPitCheckIsEmptyTest() {
//        Pit firstPit = new Pit();
//        firstPit.sendSeedsToOpponentsKahlua();
//
//        assertTrue(firstPit.getSeedCount()==0);
//    }


    @Test
    void playFirstPitCheckSeedCountIsZeroTest() throws UnplayablePitException {
        Pit firstPit = new Pit();
        firstPit.play();

        assertEquals(0, firstPit.getSeedCount());
    }

    @Test
    void playFirstPitNextPitSeedCountIs5Test() throws UnplayablePitException {
        Pit firstPit = new Pit();
        firstPit.play();

        AbstractPit resultPit = firstPit.getNextPit();

        assertEquals(5, resultPit.getSeedCount());
    }

    @Test
    void playFirstPitThirdPitSeedCountIs5Test() throws UnplayablePitException {
        Pit firstPit = new Pit();
        firstPit.play();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 2; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertEquals(5, resultPit.getSeedCount());
    }

    @Test
    void playFirstPitSixthPitSeedCountIs4Test() throws UnplayablePitException {
        Pit firstPit = new Pit();
        firstPit.play();

        AbstractPit resultPit = firstPit;
        for (int i = 0; i < 5; i++) {
            resultPit = resultPit.getNextPit();
        }

        assertEquals(4, resultPit.getSeedCount());
    }

    @Test
    void playThirdPitKahluaSeedCountIs1Test() throws UnplayablePitException {
        Pit firstPit = new Pit();
        Pit thirdPit = (Pit) firstPit.getPitAtDistance(2);
        thirdPit.play();
        AbstractPit kahlua = firstPit.getPitAtDistance(6);

        assertEquals(1, kahlua.getSeedCount());
    }

    @Test
    void playThirdPitSixthPitSeedCountIs5Test() throws UnplayablePitException {
        Pit firstPit = new Pit();
        Pit thirdPit = (Pit) firstPit.getPitAtDistance(2);
        thirdPit.play();
        AbstractPit sixthPit = firstPit.getPitAtDistance(5);

        assertEquals(5, sixthPit.getSeedCount());
    }

//    @Test
//    void playFirstPitSwitchTurnPlayer1isActiveOpponentInactiveTest() throws UnplayablePitException {
//        Pit firstPit = new Pit();
//        firstPit.play();
//
//        assertFalse(firstPit.getPlayer().isActive());
//        assertTrue(firstPit.getOppositePit().getPlayer().isActive());
//    }

    @Test
    void playPitOfInactivePlayerSwitchesTurnTest() throws UnplayablePitException {
        Pit pit1 = new Pit();
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);

        pit6.play();
        assertFalse(pit6.getPlayer().isActive());
        pit8.play();
        assertTrue(pit6.getPlayer().isActive());
    }

    @Test
    void playPossibleIfPlayerActiveSecondPitSeedCount5() throws UnplayablePitException {
        Pit firstPit = new Pit();
        AbstractPit secondPit = firstPit.getPitAtDistance(1);
        firstPit.play();

        assertEquals(5, secondPit.getSeedCount());
    }

    @Test
    void playThrowsExceptionIfPlayerInactive() {
        Pit firstPit = new Pit();
        Pit inactivePlayerPit = (Pit) firstPit.getPitAtDistance(8);

        assertThrows(UnplayablePitException.class, () -> inactivePlayerPit.play());

    }

    @Test
    void playThrowsExceptionIfPitEmpty() throws UnplayablePitException {
        Pit firstPit = new Pit();
        Pit pit8 = (Pit) firstPit.getPitAtDistance(7);

        firstPit.play();
        pit8.play();

        assertThrows(UnplayablePitException.class, () -> firstPit.play());

    }

    @Test
    void playEndInEmptyOpponentPitSoNoReapPit1ShouldHave1SeedTest() throws UnplayablePitException {
        Pit pit1 = new Pit();
        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
        Pit pit13 = (Pit) pit1.getPitAtDistance(12);

        pit1.play();
        pit11.play();


        printBoard(pit1);

        assertEquals(1, pit1.getSeedCount());
        assertEquals(5, pit13.getSeedCount());


    }

    @Test
    void playEndInEmptyPitOppositePitIsFullSoReap() throws UnplayablePitException {
        Pit pit1 = new Pit();
        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);

        pit5.play();
        pit8.play();
        pit1.play();

//        printBoard(pit1);

        assertEquals(0, pit5.getSeedCount());

        AbstractPit kahlua = pit1.getPitAtDistance(6);

        assertEquals(8, kahlua.getSeedCount());
    }

    @Test
    void playEndInSamePitAsPlayedPitShouldReap() throws UnplayablePitException {
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
        Pit pit9 = (Pit) pit1.getPitAtDistance(8);
        Pit pit10 = (Pit) pit1.getPitAtDistance(9);
        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
        Pit pit12 = (Pit) pit1.getPitAtDistance(11);
        Pit pit13 = (Pit) pit1.getPitAtDistance(12);

        pit6.play();
        pit8.play();
        pit5.play();
        pit9.play();
        pit4.play();
        pit10.play();
        pit3.play();
        pit11.play();
        pit1.play();
        pit12.play();
        pit2.play();
        pit8.play();
        pit1.play();
        pit11.play();
        pit5.play();
        pit10.play();
        pit6.play();

        pit13.play();

//        printBoard(pit1);

        AbstractPit kahlua = pit1.getPitAtDistance(13);

        assertEquals(0, pit13.getSeedCount());
        assertEquals(7, kahlua.getSeedCount());

    }

    @Test
    void playPitEndsInEmptyOpponentsPitSoNoReap() throws UnplayablePitException{
        int[] seedCountArray = {
                0,0,0,0,0,2,
                0,
                0,0,0,0,0,0,
                0};
        Pit pit1 = new Pit(seedCountArray);

        Pit pit6 = (Pit) pit1.getPitAtDistance(5);

        pit6.play();

        AbstractPit pit8 = pit1.getPitAtDistance(7);

        assertEquals(1, pit8.getSeedCount());

    }

    @Test
    void playPitEndsInEmptyPitButOppositePitIsEmptySoNoReap() throws UnplayablePitException{
        int[] seedCountArray = {
                1,0,0,0,0,0,
                0,
                1,0,0,0,0,0,
                0};
        Pit pit1 = new Pit(seedCountArray);

        pit1.play();

        AbstractPit pit2 = pit1.getNextPit();

        printBoard(pit1);

        assertEquals(0, pit1.getSeedCount());
        assertEquals(1, pit2.getSeedCount());

    }

    @Test
    void detectEndOfGameGameHasNotEnded(){
        Pit pit1 = new Pit();

        assertTrue(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameFirstPitIsEmptyGameHasNotEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);

        pit1.play();
        pit8.play();

        assertTrue(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer1PitsEmptyGameHasEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);

        pit1.play();
        pit8.play();
        pit2.play();
        pit3.play();
        pit8.play();
        pit4.play();
        pit8.play();
        pit5.play();
        pit8.play();
        pit6.play();
        pit8.play();

//        printBoard(pit1);

        assertFalse(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer1PitsEmptyButNotTheirTurnGameHasNotEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);

        pit1.play();
        pit8.play();
        pit2.play();
        pit3.play();
        pit8.play();
        pit4.play();
        pit8.play();
        pit5.play();
        pit8.play();
        pit6.play();

//        printBoard(pit1);

        assertTrue(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer2PitsEmptyGameHasEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
        Pit pit9 = (Pit) pit1.getPitAtDistance(8);
        Pit pit10 = (Pit) pit1.getPitAtDistance(9);
        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
        Pit pit12 = (Pit) pit1.getPitAtDistance(11);
        Pit pit13 = (Pit) pit1.getPitAtDistance(12);

        pit6.play();
        pit9.play();
        pit8.play();
        pit2.play();
        pit10.play();
        pit2.play();
        pit11.play();
        pit2.play();
        pit13.play();
        pit1.play();
        pit8.play();
        pit2.play();
        pit12.play();
        pit2.play();
        pit9.play();
        pit1.play();
        pit13.play();
        pit10.play();

        pit2.play();

//        printBoard(pit1);

        assertFalse(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer2PitsEmptyCallOnPit2GameHasEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
        Pit pit9 = (Pit) pit1.getPitAtDistance(8);
        Pit pit10 = (Pit) pit1.getPitAtDistance(9);
        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
        Pit pit12 = (Pit) pit1.getPitAtDistance(11);
        Pit pit13 = (Pit) pit1.getPitAtDistance(12);

        pit6.play();
        pit9.play();
        pit8.play();
        pit2.play();
        pit10.play();
        pit2.play();
        pit11.play();
        pit2.play();
        pit13.play();
        pit1.play();
        pit8.play();
        pit2.play();
        pit12.play();
        pit2.play();
        pit9.play();
        pit1.play();
        pit13.play();
        pit10.play();
        pit2.play();

//        printBoard(pit1);

        assertFalse(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer2PitsEmptyCallOnPit9GameHasEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
        Pit pit9 = (Pit) pit1.getPitAtDistance(8);
        Pit pit10 = (Pit) pit1.getPitAtDistance(9);
        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
        Pit pit12 = (Pit) pit1.getPitAtDistance(11);
        Pit pit13 = (Pit) pit1.getPitAtDistance(12);

        pit6.play();
        pit9.play();
        pit8.play();
        pit2.play();
        pit10.play();
        pit2.play();
        pit11.play();
        pit2.play();
        pit13.play();
        pit1.play();
        pit8.play();
        pit2.play();
        pit12.play();
        pit2.play();
        pit9.play();
        pit1.play();
        pit13.play();
        pit10.play();
        pit2.play();

//        printBoard(pit1);

        assertFalse(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer1PitsEmptyCallOnPit2GameHasEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);

        pit1.play();
        pit8.play();
        pit2.play();
        pit3.play();
        pit8.play();
        pit4.play();
        pit8.play();
        pit5.play();
        pit8.play();
        pit6.play();
        pit8.play();

//        printBoard(pit1);

        assertFalse(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer1PitsEmptyCallOnPit9GameHasEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
        Pit pit9 = (Pit) pit1.getPitAtDistance(8);

        pit1.play();
        pit8.play();
        pit2.play();
        pit3.play();
        pit8.play();
        pit4.play();
        pit8.play();
        pit5.play();
        pit8.play();
        pit6.play();
        pit8.play();

//        printBoard(pit1);

        assertFalse(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer1PitsEmptyButPit1AndPit6CallOnPit2GameHasNotEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);

        pit2.play();
        pit8.play();
        pit3.play();
        pit8.play();
        pit4.play();
        pit8.play();
        pit5.play();
        pit8.play();

//        printBoard(pit1);

    assertTrue(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer1PitsEmptyButPit1GameHasNotEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
        Pit pit9 = (Pit) pit1.getPitAtDistance(8);


        pit2.play();
        pit8.play();
        pit3.play();
        pit8.play();
        pit4.play();
        pit8.play();
        pit5.play();
        pit8.play();
        pit6.play();

//        printBoard(pit1);

        pit8.play();

//        printBoard(pit1);

        assertTrue(pit1.isGameActive());
    }

    @Test
    void detectEndOfGameAllPlayer2PitsEmptyButPit8GameHasNotEnded() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit9 = (Pit) pit1.getPitAtDistance(8);
        Pit pit10 = (Pit) pit1.getPitAtDistance(9);
        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
        Pit pit12 = (Pit) pit1.getPitAtDistance(11);
        Pit pit13 = (Pit) pit1.getPitAtDistance(12);

        pit6.play();
        pit9.play();
        pit10.play();
        pit4.play();
        pit11.play();
        pit2.play();
        pit12.play();
        pit2.play();
        pit13.play();

//        printBoard(pit1);

        pit2.play();

//        printBoard(pit1);

        assertTrue(pit1.isGameActive());
    }

    @Test
    void endGameAndSendAllSeedsToKahluaTest() throws UnplayablePitException{
        Pit pit1 = new Pit();
        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
        Pit pit12 = (Pit) pit1.getPitAtDistance(11);

        pit1.play();
        pit8.play();
        pit2.play();
        pit3.play();
        pit8.play();
        pit4.play();
        pit8.play();
        pit5.play();
        pit8.play();
        pit6.play();
        pit8.play();

//        printBoard(pit1);

        assertEquals(0,pit12.getSeedCount());
    }

    @Test
    void findFirstActivePitTest() throws UnplayablePitException{
        int[] seedCountArray = {
                0,0,0,0,0,2,
                0,
                0,0,0,0,0,0,
                0};
        Pit pit1 = new Pit(seedCountArray);
        AbstractPit pit6 = pit1.getPitAtDistance(5);
        AbstractPit pit8 = pit1.getPitAtDistance(7);


        ((Pit) pit6).play();
//        printBoard(pit1);
        // player 2 is active
        ((Pit) pit8).play();

//        printBoard(pit1);



//        assertEquals(0,pit12.getSeedCount());
    }

}
