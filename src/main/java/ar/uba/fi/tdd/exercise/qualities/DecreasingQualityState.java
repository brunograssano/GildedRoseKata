package ar.uba.fi.tdd.exercise.qualities;

import ar.uba.fi.tdd.exercise.Item;

public class DecreasingQualityState implements QualityState {
    @Override
    public QualityState updateQuality(Item item, int expirationModifier) {
        item.quality-=expirationModifier;
        if(item.quality <= 0){
            item.quality = 0;
            return new ConstantQualityState();
        }
        return this;
    }
}
