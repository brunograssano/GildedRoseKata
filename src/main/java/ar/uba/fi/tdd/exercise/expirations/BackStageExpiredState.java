package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.ConstantQualityState;

public class BackStageExpiredState extends ExpirationState {

    static final int MINIMUM_QUALITY = 0;

    public BackStageExpiredState(){
        this.qualityState = new ConstantQualityState();
    }

    public ExpirationState updateDay(Item item) {
        item.sellIn--;
        return this;
    }

    public void updateQuality(Item item) {
        item.quality = MINIMUM_QUALITY;
    }
}
