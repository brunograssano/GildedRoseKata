package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.ExpirationState;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public abstract class ItemUpdater {

    protected Item item;
    protected ExpirationState expirationState;
    protected QualityState qualityState;

    void update() {
        expirationState = expirationState.updateDay(item);
        qualityState = expirationState.updateQuality(item, qualityState);
    }
}
