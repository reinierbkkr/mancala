package mancala.domain;

import mancala.domain.exceptions.UnplayablePitException;

public class Mancala implements IMancala {
    private final Pit firstPit;
    private final String namePlayer1;
    private final String namePlayer2;

    public Mancala(String namePlayer1, String namePlayer2) {
        firstPit = new Pit();
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public Mancala(int[] seedCountArray){
        firstPit = new Pit(seedCountArray);
        this.namePlayer1 = "Player 1";
        this.namePlayer2 = "Player 2";
    }

    @Override
    public String getNameOfPlayerOne() {
        return namePlayer1;
    }

    @Override
    public String getNameOfPlayerTwo() {
        return namePlayer2;
    }

    @Override
    public boolean isPlayersTurn(String name) {
        if (name.equals(namePlayer1)){
            return firstPit.playerIsActive();
        } else if (name.equals(namePlayer2)){
            return !firstPit.playerIsActive();
        } else {
//            throw exception
            return false;
        }
    }

    @Override
    public void playPit(int index) {
        try {
            firstPit.playPitAtPosition(index);
        } catch (UnplayablePitException e) {
            // notify client
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
