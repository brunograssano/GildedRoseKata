package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public abstract class ExpirationState {

    protected QualityState qualityState;

    abstract public ExpirationState updateDay(Item item);

    abstract public void updateQuality(Item item);

}
