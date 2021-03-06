package ar.uba.fi.tdd.exercise.qualities;

import ar.uba.fi.tdd.exercise.Item;

public class IncreasingQualityState implements QualityState {

    static final int MAX_QUALITY = 50;

    @Override
    public QualityState updateQuality(Item item, int expirationModifier) {
        item.quality+=expirationModifier;
        if (item.quality >= MAX_QUALITY){
            item.quality = MAX_QUALITY;
            return new ConstantQualityState();
        }
        return this;
    }

}
