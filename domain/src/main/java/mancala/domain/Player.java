package mancala.domain;

class Player {
    private boolean active = false;

    private final Player opponent;

//    private final String name;

    Player() {
        opponent = new Player(this);
        active = true;
    }

    private Player(Player opponent) {
        this.opponent = opponent;
    }

    public boolean isActive() {
        return active;
    }

    Player getOpponent() {
        return opponent;
    }

    private void activate() {
        active = true;
    }

    void switchTurn() {
        if (!active) {
            opponent.switchTurn();
        } else {
            active = false;
            opponent.activate();
        }
    }
}
