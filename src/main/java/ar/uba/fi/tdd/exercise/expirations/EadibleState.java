package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public class EadibleState implements ExpirationState {

    static final int NORMAL_QUALITY_CHANGE = 1;

    public ExpirationState updateDay(Item item){
        item.sellIn--;
        if(item.sellIn<0){
            return new NormalExpiredState();
        }
        return this;
    }

    @Override
    public QualityState updateQuality(Item item, QualityState qualityState) {
        return qualityState.updateQuality(item, NORMAL_QUALITY_CHANGE);
    }


}
