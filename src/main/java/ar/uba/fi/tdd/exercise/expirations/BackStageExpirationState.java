package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public class BackStageExpirationState implements ExpirationState {

    static final int TEN_DAYS_TO_CONCERT = 10;
    static final int FIVE_DAYS_TO_CONCERT = 5;

    static final int NORMAL_MODIFIER = 1;
    static final int TEN_DAYS_MODIFIER = 2;
    static final int FIVE_DAYS_MODIFIER = 3;

    @Override
    public ExpirationState updateDay(Item item) {
        item.sellIn--;
        if(item.sellIn<0){
            return new BackStageExpiredState();
        }
        return this;
    }

    @Override
    public QualityState updateQuality(Item item, QualityState qualityState) {

        int modifier = NORMAL_MODIFIER;

        if (item.sellIn <= FIVE_DAYS_TO_CONCERT){
            modifier = FIVE_DAYS_MODIFIER;
        } else if (item.sellIn <= TEN_DAYS_TO_CONCERT){
            modifier = TEN_DAYS_MODIFIER;
        }

        return qualityState.updateQuality(item,modifier);
    }
}
