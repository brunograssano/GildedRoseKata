package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.BackStageNormalState;
import ar.uba.fi.tdd.exercise.qualities.IncreasingQualityState;

public class BackstageUpdater extends ItemUpdater {
    public BackstageUpdater(Item item) {
        this.item = item;
        this.expirationState = new BackStageNormalState();
        this.qualityState = new IncreasingQualityState();
    }

}
