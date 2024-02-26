package mancala.domain;

import mancala.domain.exceptions.UnplayablePitException;

class Pit extends AbstractPit {
    private final Player player;
    private int seedCount = 4;
    private final AbstractPit nextPit;

    Pit() {
        player = new Player();
        nextPit = new Pit(1, player, this);
    }

    Pit(int index, Player player, AbstractPit firstPit) {
        this.player = player;
        index++;
        if (index == 6) {
            nextPit = new Kahlua(index, player, firstPit);
        } else if (index == 13) {
            nextPit = new Kahlua(player, firstPit);
        } else {
            nextPit = new Pit(index, player, firstPit);
        }
    }

    Pit(int[] seedCountArray) {
        // for testing
        player = new Player();
        nextPit = new Pit(1, player, this, seedCountArray);
        seedCount = seedCountArray[0];
    }

    Pit(int index, Player player, AbstractPit firstPit, int[] seedCountArray) {
        // for testing
        this.player = player;
        seedCount = seedCountArray[index];
        index++;
        if (index == 6) {
            nextPit = new Kahlua(index, player, firstPit, seedCountArray);
        } else if (index == 13) {
            nextPit = new Kahlua(player, firstPit, seedCountArray);
        } else {
            nextPit = new Pit(index, player, firstPit, seedCountArray);
        }
    }

    @Override
    Player getPlayer() {
        return player;
    }

    @Override
    int getSeedCount() {
        return seedCount;
    }

    @Override
    AbstractPit getNextPit() {
        return nextPit;
    }

    @Override
    AbstractPit getPitAtDistance(int distance) {
        return (distance == 0)
                ? this
                : nextPit.getPitAtDistance(distance - 1);
    }

    @Override
    int getDistanceToKahlua() {
        return 1 + nextPit.getDistanceToKahlua();
    }

    private Kahlua getOwnKahlua() {
        return (Kahlua) getPitAtDistance(getDistanceToKahlua());
    }

    private Kahlua getOpponentKahlua() {
        return (Kahlua) getPitAtDistance(getDistanceToKahlua() + 7);
    }

    private Pit getOppositePit() {
        int distance = 2 * getDistanceToKahlua();
        return (Pit) getPitAtDistance(distance);
    }

    void play() throws UnplayablePitException {//refactor
        if (!isEmpty() && player.isActive()) {// conditional misschien overbodig als op hoger niveau keuze gelimiteerd wordt
            int amount = seedCount;
            seedCount = 0;
            nextPit.sow(amount);
        } else {
            throw new UnplayablePitException();
        }
    }

    private boolean isEmpty() {
        return seedCount == 0;
    }

    @Override
    void sow(int amount) {
        seedCount++;
        if (amount > 1) {
            nextPit.sow(amount - 1);
        }
        if (amount == 1) {
            reap();
            player.switchTurn();
            endGameIfPossible();
        }
    }

    private void reap() {
        if (player.isActive() && wasEmpty() && !getOppositePit().isEmpty()) {
            getOppositePit().sendSeedsToOpponentsKahlua();
            sendAllSeedsToOwnKahlua();
        }
    }

    private boolean wasEmpty() {
        return seedCount == 1;
    }

    private void sendAllSeedsToOwnKahlua() {
        getOwnKahlua().receiveSeeds(seedCount);
        seedCount = 0;
    }

    private void sendSeedsToOpponentsKahlua() {
        getOpponentKahlua().receiveSeeds(seedCount);
        seedCount = 0;
    }

    @Override
    void endGameIfPossible() {
        getFirstActivePit().detectActivePitsEmptyAndEndGame();
    }

    @Override
    Pit getFirstActivePit() {
        return (player.isActive())
                ? this
                : getOwnKahlua().getFirstActivePit();
    }

    @Override
    void detectActivePitsEmptyAndEndGame() {
        if (isEmpty()) nextPit.detectActivePitsEmptyAndEndGame();
    }

    @Override
    void endGameSendAllPitsSeedsToKahlua() {
        sendAllSeedsToOwnKahlua();
        nextPit.endGameSendAllPitsSeedsToKahlua();
    }


    // interactie met client
    @Override
    public boolean isGameActive() {
        return getOwnKahlua().isGameActive() && getOpponentKahlua().isGameActive();
    }

    @Override
    public int getSeedCountAtPosition(int index) {
        return getPitAtDistance(index).getSeedCount();
    }

    public void playPitAtPosition(int index) throws UnplayablePitException {((Pit) getPitAtDistance(index)).play();}

    public boolean playerIsActive(){
        return player.isActive();
    }

    public boolean opponentIsActive(){
        return player.getOpponent().isActive();
    }

}
