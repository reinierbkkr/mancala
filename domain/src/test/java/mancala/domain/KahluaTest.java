package mancala.domain;

import mancala.domain.exceptions.UnplayablePitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KahluaTest {
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
    void kahluaSowShouldNotTakeWhenItsPlayerIsInactiveTest() throws UnplayablePitException {
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
        Pit pit13 = (Pit) pit1.getPitAtDistance(12);

        pit6.play();
        pit8.play();
        pit5.play();
        pit9.play();
        pit4.play();
        pit10.play();
        pit3.play();
        pit11.play();
        pit2.play();

        pit13.play();

//        printBoard(pit1);

        AbstractPit kahlua = pit1.getPitAtDistance(6);

        assertEquals(5, kahlua.getSeedCount());

    }

    @Test
    void kahluaSowShouldPassWhenItsPlayerIsInactiveTest() throws UnplayablePitException {
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
        Pit pit13 = (Pit) pit1.getPitAtDistance(12);

        pit6.play();
        pit8.play();
        pit5.play();
        pit9.play();
        pit4.play();
        pit10.play();
        pit3.play();
        pit11.play();
        pit2.play();

        pit13.play();

//        printBoard(pit1);

        assertEquals(5, pit8.getSeedCount());

    }

    @Test
    void kahluaSowShouldPassSeedsWhenItsPlayerIsInactiveMoreThanOneSeedTest() throws UnplayablePitException {
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

        pit13.play();
//        printBoard(pit1);

        assertEquals(2, pit9.getSeedCount());

    }

    @Test
    void dontSwitchTurnIfEndsInOwnKahluaTest() throws UnplayablePitException {
        Pit firstPit = new Pit();
        Pit thirdPit = (Pit) firstPit.getPitAtDistance(2);

        thirdPit.play();

        assertTrue(firstPit.getPlayer().isActive());

    }

//    @Test
//    void detectEndOfGameGameHasNotEnded(){
//        Pit pit1 = new Pit();
//
//        IPit kahlua = pit1.getPitAtDistance(6);
//
//        assertFalse(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameFirstPitIsEmptyGameHasNotEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//
//        pit1.play();
//        pit8.play();
//
//        IPit kahlua = pit1.getPitAtDistance(6);
//
//        assertFalse(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer1PitsEmptyGameHasEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
//        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
//        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
//        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//
//        pit1.play();
//        pit8.play();
//        pit2.play();
//        pit3.play();
//        pit8.play();
//        pit4.play();
//        pit8.play();
//        pit5.play();
//        pit8.play();
//        pit6.play();
//        pit8.play();
//
////        printBoard(pit1);
//
//        IPit kahlua = pit1.getPitAtDistance(6);
//
//        assertTrue(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer1PitsEmptyButNotTheirTurnGameHasNotEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
//        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
//        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
//        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//
//        pit1.play();
//        pit8.play();
//        pit2.play();
//        pit3.play();
//        pit8.play();
//        pit4.play();
//        pit8.play();
//        pit5.play();
//        pit8.play();
//        pit6.play();
//
////        printBoard(pit1);
//
//        assertFalse(pit1.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer2PitsEmptyGameHasEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//        Pit pit9 = (Pit) pit1.getPitAtDistance(8);
//        Pit pit10 = (Pit) pit1.getPitAtDistance(9);
//        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
//        Pit pit12 = (Pit) pit1.getPitAtDistance(11);
//        Pit pit13 = (Pit) pit1.getPitAtDistance(12);
//
//        pit6.play();
//        pit9.play();
//        pit8.play();
//        pit2.play();
//        pit10.play();
//        pit2.play();
//        pit11.play();
//        pit2.play();
//        pit13.play();
//        pit1.play();
//        pit8.play();
//        pit2.play();
//        pit12.play();
//        pit2.play();
//        pit9.play();
//        pit1.play();
//        pit13.play();
//        pit10.play();
//        pit2.play();
//
//        printBoard(pit1);
//
//        IPit kahlua = pit1.getPitAtDistance(6);
//
//        assertTrue(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer2PitsEmptyCallOnKahlua1GameHasEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//        Pit pit9 = (Pit) pit1.getPitAtDistance(8);
//        Pit pit10 = (Pit) pit1.getPitAtDistance(9);
//        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
//        Pit pit12 = (Pit) pit1.getPitAtDistance(11);
//        Pit pit13 = (Pit) pit1.getPitAtDistance(12);
//
//        pit6.play();
//        pit9.play();
//        pit8.play();
//        pit2.play();
//        pit10.play();
//        pit2.play();
//        pit11.play();
//        pit2.play();
//        pit13.play();
//        pit1.play();
//        pit8.play();
//        pit2.play();
//        pit12.play();
//        pit2.play();
//        pit9.play();
//        pit1.play();
//        pit13.play();
//        pit10.play();
//        pit2.play();
//
////        printBoard(pit1);
//
//        IPit kahlua = pit1.getPitAtDistance(6);
//
//        assertTrue(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer2PitsEmptyCallOnKahlua2GameHasEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//        Pit pit9 = (Pit) pit1.getPitAtDistance(8);
//        Pit pit10 = (Pit) pit1.getPitAtDistance(9);
//        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
//        Pit pit12 = (Pit) pit1.getPitAtDistance(11);
//        Pit pit13 = (Pit) pit1.getPitAtDistance(12);
//
//        pit6.play();
//        pit9.play();
//        pit8.play();
//        pit2.play();
//        pit10.play();
//        pit2.play();
//        pit11.play();
//        pit2.play();
//        pit13.play();
//        pit1.play();
//        pit8.play();
//        pit2.play();
//        pit12.play();
//        pit2.play();
//        pit9.play();
//        pit1.play();
//        pit13.play();
//        pit10.play();
//        pit2.play();
//
////        printBoard(pit1);
//
//        IPit kahlua = pit1.getPitAtDistance(13);
//
//        assertTrue(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer1PitsEmptyCallOnKahlua1GameHasEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
//        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
//        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
//        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//
//        pit1.play();
//        pit8.play();
//        pit2.play();
//        pit3.play();
//        pit8.play();
//        pit4.play();
//        pit8.play();
//        pit5.play();
//        pit8.play();
//        pit6.play();
//        pit8.play();
//
////        printBoard(pit1);
//
//        IPit kahlua = pit1.getPitAtDistance(6);
//
//        assertTrue(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer1PitsEmptyCallOnKahlua2GameHasEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
//        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
//        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
//        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//
//        pit1.play();
//        pit8.play();
//        pit2.play();
//        pit3.play();
//        pit8.play();
//        pit4.play();
//        pit8.play();
//        pit5.play();
//        pit8.play();
//        pit6.play();
//        pit8.play();
//
////        printBoard(pit1);
//
//        IPit kahlua = pit1.getPitAtDistance(13);
//
//        assertTrue(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer1PitsEmptyButPit1AndPit6CallOnKahlua1GameHasNotEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
//        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
//        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//
//        pit2.play();
//        pit8.play();
//        pit3.play();
//        pit8.play();
//        pit4.play();
//        pit8.play();
//        pit5.play();
//        pit8.play();
//
////        printBoard(pit1);
//
//        IPit kahlua = pit1.getPitAtDistance(6);
//
//        assertFalse(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer1PitsEmptyButPit1CallOnKahlua1GameHasNotEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit3 = (Pit) pit1.getPitAtDistance(2);
//        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
//        Pit pit5 = (Pit) pit1.getPitAtDistance(4);
//        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
//        Pit pit8 = (Pit) pit1.getPitAtDistance(7);
//
//        pit2.play();
//        pit8.play();
//        pit3.play();
//        pit8.play();
//        pit4.play();
//        pit8.play();
//        pit5.play();
//        pit8.play();
//        pit6.play();
//        pit8.play();
//
////        printBoard(pit1);
//
//        IPit kahlua = pit1.getPitAtDistance(6);
//
//        assertFalse(kahlua.detectEndOfGame());
//    }
//
//    @Test
//    void detectEndOfGameAllPlayer2PitsEmptyButPit8CallOnKahlua2GameHasNotEnded() throws UnplayablePitException{
//        Pit pit1 = new Pit();
//        Pit pit2 = (Pit) pit1.getPitAtDistance(1);
//        Pit pit4 = (Pit) pit1.getPitAtDistance(3);
//        Pit pit6 = (Pit) pit1.getPitAtDistance(5);
//        Pit pit9 = (Pit) pit1.getPitAtDistance(8);
//        Pit pit10 = (Pit) pit1.getPitAtDistance(9);
//        Pit pit11 = (Pit) pit1.getPitAtDistance(10);
//        Pit pit12 = (Pit) pit1.getPitAtDistance(11);
//        Pit pit13 = (Pit) pit1.getPitAtDistance(12);
//
//        pit6.play();
//        pit9.play();
//        pit10.play();
//        pit4.play();
//        pit11.play();
//        pit2.play();
//        pit12.play();
//        pit2.play();
//        pit13.play();
//        pit2.play();
//
////        printBoard(pit1);
//
//        IPit kahlua = pit1.getPitAtDistance(13);
//
//        assertFalse(kahlua.detectEndOfGame());
//    }

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

        assertEquals(0,pit12.getSeedCount());
    }

}
