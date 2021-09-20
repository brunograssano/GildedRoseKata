package ar.uba.fi.tdd.exercise.qualities;

import ar.uba.fi.tdd.exercise.Item;

public interface QualityState {

    QualityState updateQuality(Item item, int expirationModifier);

}
