package ar.uba.fi.tdd.exercise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GildedRoseTest {

	static final String NORMAL_ITEM = "Tasty Mawshroom";
	static final String AGED_BRIE = "Aged Brie";
	static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

	@Test
	public void atTheEndOfADayTheSellinAndQualityValuesDecreasesInARegularItem01() {
		Item[] items = new Item[] { new Item(NORMAL_ITEM, 5, 5) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(4,app.items[0].quality,"The quality value of a normal item decreases after an update");
		assertEquals(4,app.items[0].sellIn,"The SellIn value of a normal item decreases after an update");
	}

	@Test
	public void ifTheSellByDatePassedTheQualityValueDecreasesTwiceAsFastInARegularItem02() {
		Item[] items = new Item[] { new Item(NORMAL_ITEM, 0, 5) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(3,app.items[0].quality,"The quality value of a normal item decreases twice as fast if the sell by date passes after an update");
		assertEquals(-1,app.items[0].sellIn,"The SellIn value of a normal item indicates that the product has expired");
	}

	@Test
	public void theQualityOfAnItemCannotBeNegative03() {
		Item[] items = new Item[] { new Item(NORMAL_ITEM, 5, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0,app.items[0].quality,"The quality value of a normal item cannot be negative");
		assertEquals(4,app.items[0].sellIn,"The SellIn value of a normal item decreases after an update");
	}

	@Test
	public void theQualityOfAnItemThatHasExpiredCannotBeNegative04() {
		Item[] items = new Item[] { new Item(NORMAL_ITEM, 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0,app.items[0].quality,"The quality value of a normal item that expired cannot be negative");
		assertEquals(-1,app.items[0].sellIn,"The SellIn value of a normal item that has 0 quality is negative");
	}

	@Test
	public void agedBrieIncreasesInQualityTheOlderItGets05() {
		Item[] items = new Item[] { new Item(AGED_BRIE, 5, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(11,app.items[0].quality,"The quality value of aged brie increases after an update");
		assertEquals(4,app.items[0].sellIn,"The SellIn value of aged brie decreases");
	}

	@Test
	public void agedBrieIncreasesItsQualityByTwoAfterItExpires06() {
		Item[] items = new Item[] { new Item(AGED_BRIE, 0, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(12,app.items[0].quality,"The quality value of aged brie increases twice as fast after an update");
		assertEquals(-1,app.items[0].sellIn,"The SellIn value of aged brie decreases");
	}

	@Test
	public void theQualityOfAgedBrieIsNeverMoreThanFifty07() {
		Item[] items = new Item[] { new Item(AGED_BRIE, 1, 50) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(50,app.items[0].quality,"The quality value of aged brie is never more than 50");
		assertEquals(0,app.items[0].sellIn,"The SellIn value of aged brie decreases");
	}

	@Test
	public void theQualityOfAgedBrieIsNeverMoreThanFiftyAfterExpiring08() {
		Item[] items = new Item[] { new Item(AGED_BRIE, 0, 50) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(50,app.items[0].quality,"The quality value of aged brie is never more than 50 after expiring");
		assertEquals(-1,app.items[0].sellIn,"The SellIn value of aged brie expires");
	}

	@Test
	public void sulfurasHasTheSameSellInAndQualityValuesAfterAnUpdate09() {
		Item[] items = new Item[] { new Item(SULFURAS, 5, 80) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(80,app.items[0].quality,"The quality of sulfuras is still 80 after an update");
		assertEquals(5,app.items[0].sellIn,"The SellIn value of sulfuras is still 5 after an update");
	}

	@Test
	public void sulfurasHasTheSameSellInAndQualityValuesAfterAnUpdate10() {
		Item[] items = new Item[] { new Item(SULFURAS, 5, 80) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(80,app.items[0].quality,"The quality of sulfuras is still 80 after an update");
		assertEquals(5,app.items[0].sellIn,"The SellIn value of sulfuras is still 5 after an update");
	}

	@Test
	public void backstageItemsIncreaseInQualityBy2WhenThereAre10DaysOrLessForTheConcert11() {
		Item[] items = new Item[] { new Item(BACKSTAGE, 7, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(12,app.items[0].quality,"The quality of a backstage item increases by 2 when there are 10 days or less for the concert");
	}

	@Test
	public void backstageItemsIncreaseInQualityBy3WhenThereAre5DaysOrLessForTheConcert12() {
		Item[] items = new Item[] { new Item(BACKSTAGE, 5, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(13,app.items[0].quality,"The quality of a backstage item increases by 3 when there are 5 days or less for the concert");
	}

	@Test
	public void theQualityOfBackstageItemsDecreasesTo0AfterTheConcert13() {
		Item[] items = new Item[] { new Item(BACKSTAGE, 0, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0,app.items[0].quality,"The quality after the concert is 0");
		assertEquals(-1,app.items[0].sellIn,"The backstage sell by date expired");
	}

}
