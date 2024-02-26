package mancala.domain;

import mancala.domain.exceptions.UnplayablePitException;

public class Mancala implements IMancala {
    private Pit firstPit;

    public Mancala(String namePlayer1, String namePlayer2) {
        firstPit = new Pit();
    }

    public Mancala(int[] seedCountArray){
        firstPit = new Pit(seedCountArray);
    }

    @Override
    public String getNameOfPlayerOne() {
        return null;
    }

    @Override
    public String getNameOfPlayerTwo() {
        return null;
    }

    @Override
    public boolean isPlayersTurn(String name) {
        return false;
    }

    @Override
    public void playPit(int index) {
        try {
            firstPit.playPitAtPosition(index);
        } catch (UnplayablePitException e) {
            System.out.println("Error occurred: " + e);
        }
    }

    @Override
    public int getStonesForPit(int index) {
        return firstPit.getSeedCountAtPosition(index);
    }

    @Override
    public boolean isEndOfGame() {
        return !firstPit.isGameActive();
    }

    @Override
    public Winner getWinner() {
        return (isEndOfGame())
                ? determineWinner()
                : Winner.NO_ONE;
    }

    private Winner determineWinner() {
        int seedsKahlua1 = firstPit.getSeedCountAtPosition(6);
        int seedsKahlua2 = firstPit.getSeedCountAtPosition(13);
        if (seedsKahlua1 > seedsKahlua2){
            return Winner.PLAYER_1;
        } else if (seedsKahlua2 > seedsKahlua1){
            return Winner.PLAYER_2;
        } else {
            return Winner.DRAW;
        }
    }
}
