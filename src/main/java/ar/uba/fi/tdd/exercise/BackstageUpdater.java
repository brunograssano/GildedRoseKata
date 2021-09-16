package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.BackStageExpirationState;
import ar.uba.fi.tdd.exercise.qualities.IncreasingQualityState;

public class BackstageUpdater extends ItemUpdater {
    public BackstageUpdater(Item item) {
        this.item = item;
        this.expirationState = new BackStageExpirationState();
        this.qualityState = new IncreasingQualityState();
    }

}
