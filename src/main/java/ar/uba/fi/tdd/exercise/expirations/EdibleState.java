package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public class EdibleState extends ExpirationState {

    static final int NORMAL_QUALITY_CHANGE = 1;
    static final int DEADLINE = 0;

    public EdibleState(QualityState qualityState){
        this.qualityState = qualityState;
    }

    public ExpirationState updateDay(Item item){
        item.sellIn--;
        if(item.sellIn < DEADLINE){
            return new ExpiredState(qualityState);
        }
        return this;
    }


    public void updateQuality(Item item) {
        qualityState = qualityState.updateQuality(item, NORMAL_QUALITY_CHANGE);
    }


}
