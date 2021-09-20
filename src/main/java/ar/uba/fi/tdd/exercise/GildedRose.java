
package ar.uba.fi.tdd.exercise;

import java.util.ArrayList;

class GildedRose {
    Item[] items;

    private ArrayList<ItemUpdater> itemUpdaters;

    public GildedRose(Item[] _items) {
        items = _items;
        itemUpdaters = new ArrayList<>();
        for (Item item: items) {
            itemUpdaters.add(ItemUpdaterFactory.getUpdaterFor(item));
        }
    }

    public void updateQuality() {
        for (ItemUpdater itemUpdater:itemUpdaters) {
            itemUpdater.update();
        }
    }
}
