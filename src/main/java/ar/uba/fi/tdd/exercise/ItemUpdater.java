package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.ExpirationState;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public abstract class ItemUpdater {

    protected Item item;
    protected ExpirationState expirationState;
    protected QualityState qualityState;

    abstract void update();
}
