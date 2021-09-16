package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.EadibleState;
import ar.uba.fi.tdd.exercise.qualities.DecreasingQualityState;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public class ConjuredUpdater extends ItemUpdater {

    public ConjuredUpdater(Item item) {
        this.item = item;
        QualityState decreasingQuality = new DecreasingQualityState();
        this.expirationState = new EadibleState(decreasingQuality);
    }

    @Override
    void update() {
        expirationState = expirationState.updateDay(item);
        expirationState.updateQuality(item);
        expirationState.updateQuality(item);
    }

}
