
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

        for (Item item : items) {

            if (!item.Name.equals("Aged Brie")
                && !item.Name.equals("Backstage passes to a TAFKAL80ETC concert")) {

            } else { // Aged Brie case
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.Name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                          // si es menor que 6
                        if (item.sellIn < 6) {
                            // si la cantidad es es menor que 50
                            if (item.quality < 50) {
                                // sumo 1 a la calidad
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (item.Name.equals("Aged Brie") || item.Name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.Name.equals("Aged Brie")) {
                    if (!item.Name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                    } else {
                        item.quality = 0;
                    }
                } else {  // Aged Brie case
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
