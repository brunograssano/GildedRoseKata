package ar.uba.fi.tdd.exercise;

import ar.uba.fi.tdd.exercise.expirations.BackStageNormalState;

public class BackstageUpdater extends ItemUpdater {
    public BackstageUpdater(Item item) {
        this.item = item;
        this.expirationState = new BackStageNormalState();
    }

}
