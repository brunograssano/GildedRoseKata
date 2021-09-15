package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.EadibleState;
import ar.uba.fi.tdd.exercise.qualities.DecreasingQualityState;

public class NormalUpdater extends ItemUpdater {


    public NormalUpdater(Item item) {
        this.item = item;
        this.expirationState = new EadibleState();
        this.qualityState = new DecreasingQualityState();
    }

    public void update(){
        expirationState = expirationState.updateDay(item);
        qualityState = expirationState.updateQuality(item, qualityState);
    }

}
