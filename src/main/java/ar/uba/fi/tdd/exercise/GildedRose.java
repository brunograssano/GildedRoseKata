
package ar.uba.fi.tdd.exercise;

class GildedRose {
  Item[] items;

    public GildedRose(Item[] _items) {
        items = _items;
    }

    // update the quality of the emements
    public void updateQuality() {
        // for each item
        for (Item item : items) {

            if (!item.Name.equals("Aged Brie")
                && !item.Name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0){
                    if (!item.Name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
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

            if (!item.Name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.Name.equals("Aged Brie")) {
                    if (!item.Name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.Name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
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
