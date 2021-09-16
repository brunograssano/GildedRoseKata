package ar.uba.fi.tdd.exercise.qualities;

import ar.uba.fi.tdd.exercise.Item;

public class ConstantQualityState implements QualityState {
    @Override
    public QualityState updateQuality(Item item, int expirationModifier) {
        return this;
    }
}
