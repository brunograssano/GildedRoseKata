package ar.uba.fi.tdd.exercise.qualities;

import ar.uba.fi.tdd.exercise.Item;

public class DecreasingQualityState implements QualityState {

    static final int MINIMUM_QUALITY = 0;

    @Override
    public QualityState updateQuality(Item item, int expirationModifier) {
        item.quality-=expirationModifier;
        if(item.quality <= MINIMUM_QUALITY){
            item.quality = MINIMUM_QUALITY;
            return new ConstantQualityState();
        }
        return this;
    }
}
