package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.ExpirationState;

public abstract class ItemUpdater {

    protected Item item;
    protected ExpirationState expirationState;

    void update() {
        expirationState = expirationState.updateDay(item);
        expirationState.updateQuality(item);
    }
}
