package ar.uba.fi.tdd.exercise;




public class ItemUpdaterFactory {

    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    static ItemUpdater getUpdaterFor(Item item){

        ItemUpdater itemUpdater;

        switch (item.Name){
            case AGED_BRIE:
                itemUpdater = new AgedBrieUpdater(item);
                break;
            case BACKSTAGE:
                itemUpdater = new BackstageUpdater(item);
                break;
            case SULFURAS:
                itemUpdater = new NoUpdater();
                break;
            default:
                itemUpdater = new NormalUpdater(item);
        }

        return itemUpdater;
    }


}
