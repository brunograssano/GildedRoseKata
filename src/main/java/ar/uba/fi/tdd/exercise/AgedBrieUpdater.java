package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.EadibleState;
import ar.uba.fi.tdd.exercise.qualities.IncreasingQualityState;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public class AgedBrieUpdater extends ItemUpdater {

    public AgedBrieUpdater(Item item) {
        this.item = item;
        QualityState increasingQuality = new IncreasingQualityState();
        this.expirationState = new EadibleState(increasingQuality);
    }

}
