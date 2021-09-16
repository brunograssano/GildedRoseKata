package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.EadibleState;
import ar.uba.fi.tdd.exercise.qualities.IncreasingQualityState;

public class AgedBrieUpdater extends ItemUpdater {

    public AgedBrieUpdater(Item item) {
        this.item = item;
        this.expirationState = new EadibleState();
        this.qualityState = new IncreasingQualityState();
    }

}
