package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public class NormalExpiredState extends ExpirationState {

    static final int NORMAL_EXPIRED_EFFECT = 2;

    public NormalExpiredState(QualityState qualityState){
        this.qualityState = qualityState;
    }

    public ExpirationState updateDay(Item item) {
        item.sellIn--;
        return this;
    }

    public void updateQuality(Item item) {
        qualityState = qualityState.updateQuality(item, NORMAL_EXPIRED_EFFECT);
    }
}
