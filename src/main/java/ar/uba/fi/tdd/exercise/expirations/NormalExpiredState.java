package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public class NormalExpiredState implements ExpirationState {

    static final int DEGRADATION_AFTER_EXPIRATION = 2;

    @Override
    public ExpirationState updateDay(Item item) {
        item.sellIn--;
        return this;
    }

    @Override
    public QualityState updateQuality(Item item, QualityState qualityState) {
        return qualityState.updateQuality(item, DEGRADATION_AFTER_EXPIRATION);
    }
}
