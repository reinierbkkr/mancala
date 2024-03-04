package mancala.domain;


abstract class AbstractPit {
    abstract Player getPlayer();

    abstract int getSeedCount();

    abstract AbstractPit getNextPit();

    abstract AbstractPit getPitAtDistance(int distance);

    abstract int getDistanceToKahlua();

    abstract void sow(int amount);

    abstract void endGameIfPossible();

    abstract Pit getFirstActivePit();

    abstract void detectActivePitsEmptyAndEndGame();

    abstract void endGameSendAllPitsSeedsToKahlua();

    public abstract int getSeedCountAtPosition(int index);

    public abstract boolean isGameActive();

}