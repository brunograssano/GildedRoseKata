package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.IncreasingQualityState;

public class BackStageNormalState extends ExpirationState {

    static final int TEN_DAYS_TO_CONCERT = 9;
    static final int FIVE_DAYS_TO_CONCERT = 4;

    static final int NORMAL_MODIFIER = 1;
    static final int TEN_DAYS_MODIFIER = 2;
    static final int FIVE_DAYS_MODIFIER = 3;

    static final int DEADLINE = 0;

    public BackStageNormalState(){
        this.qualityState = new IncreasingQualityState();
    }

    public ExpirationState updateDay(Item item) {
        item.sellIn--;
        if(item.sellIn < DEADLINE){
            return new BackStageExpiredState();
        }
        return this;
    }

    public void updateQuality(Item item) {

        int modifier = NORMAL_MODIFIER;

        if (item.sellIn <= FIVE_DAYS_TO_CONCERT){
            modifier = FIVE_DAYS_MODIFIER;
        } else if (item.sellIn <= TEN_DAYS_TO_CONCERT){
            modifier = TEN_DAYS_MODIFIER;
        }

        qualityState = qualityState.updateQuality(item,modifier);
    }
}
