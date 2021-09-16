package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public class BackStageExpiredState implements ExpirationState {

    static final int MINIMUM_QUALITY = 0;

    @Override
    public ExpirationState updateDay(Item item) {
        item.sellIn--;
        return this;
    }

    @Override
    public QualityState updateQuality(Item item, QualityState qualityState) {
        item.quality = MINIMUM_QUALITY;
        return qualityState;
    }
}
