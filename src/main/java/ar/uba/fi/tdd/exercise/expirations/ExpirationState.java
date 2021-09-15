package ar.uba.fi.tdd.exercise.expirations;

import ar.uba.fi.tdd.exercise.Item;
import ar.uba.fi.tdd.exercise.qualities.QualityState;

public interface ExpirationState {

    ExpirationState updateDay(Item item);

    QualityState updateQuality(Item item, QualityState qualityState);

}
