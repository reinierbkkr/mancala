package mancala.persistence;

import mancala.domain.IMancala;

import java.util.HashMap;

public class MancalaMemRepository implements IMancalaRepository{
    private final HashMap<String, IMancala> storage = new HashMap<>();
    @Override
    public void save(String key, IMancala game) {
        storage.put(key, game);
    }

    @Override
    public IMancala get(String key) {
        return storage.get(key);
    }
}
