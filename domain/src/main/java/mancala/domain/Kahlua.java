package mancala.domain;

class Kahlua extends AbstractPit {
    private boolean gameActive = true;
    private final Player player;
    private int seedCount = 0;
    private final AbstractPit nextPit;

    Kahlua(int index, Player player, AbstractPit firstPit) {
        this.player = player;
        index++;
        nextPit = new Pit(index, player.getOpponent(), firstPit);
    }

    Kahlua(Player player, AbstractPit firstPit) {
        this.player = player;
        nextPit = firstPit;
    }

    Kahlua(int index, Player player, AbstractPit firstPit, int[] seedCountArray) {
        // alleen om te testen
        this.player = player;
        seedCount = seedCountArray[index];
        index++;
        nextPit = new Pit(index, player.getOpponent(), firstPit, seedCountArray);
    }

    Kahlua(Player player, AbstractPit firstPit, int[] seedCountArray) {
        // alleen om te testen
        this.player = player;
        seedCount = seedCountArray[13];
        nextPit = firstPit;
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
        return 0;
    }

    @Override
    void sow(int amount) { // refactor
        if (player.isActive()) {
            seedCount++;
            sowAndContinueTurn(amount);
        } else {
            nextPit.sow(amount);
        }
    }

    void sowAndContinueTurn(int amount) {
        if (amount > 1) {
            nextPit.sow(amount - 1);
        }
        if (amount == 1) {
            endGameIfPossible(); // should notify client to make another move
        }
    }

    void receiveSeeds(int amount) {
        seedCount += amount;
    }

    @Override
    void endGameIfPossible() {
        getPitAtDistance(8).detectActivePitsEmptyAndEndGame();
        // notify client game has ended
        // notify client to make another move
    }

    @Override
    Pit getFirstActivePit() {
        return nextPit.getFirstActivePit();
    }

    @Override
    void detectActivePitsEmptyAndEndGame() {
        nextPit.endGameSendAllPitsSeedsToKahlua();
    }

    @Override
    void endGameSendAllPitsSeedsToKahlua() {
        gameActive = false;
    }

    @Override
    public boolean isGameActive() {
        return gameActive;
    }

    @Override
    public int getSeedCountAtPosition(int index) {
        return getPitAtDistance(index).getSeedCount();
    }

}
