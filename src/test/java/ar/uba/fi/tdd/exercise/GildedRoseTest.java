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
	static final String CONJURED = "Conjured";

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

	@Test
	public void aConjuredItemDegradesTwiceAsFastAsANormalItemAfterAnUpdate14() {
		Item[] items = new Item[] { new Item(CONJURED, 10, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(8,app.items[0].quality,"The quality after an update in a conjured item decreases by 2");
		assertEquals(9,app.items[0].sellIn,"The sell by value decreases by 1 in a conjured item");
	}

	@Test
	public void aConjuredItemDegradesTwiceAsFastAsANormalItemWhileExpiredAfterAnUpdate15() {
		Item[] items = new Item[] { new Item(CONJURED, 0, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(6,app.items[0].quality,"The quality after an update in a conjured item decreases by 4");
		assertEquals(-1,app.items[0].sellIn,"The conjured item expired");
	}

	@Test
	public void theMinimumQualityOfAConjuredItemIsZero16() {
		Item[] items = new Item[] { new Item(CONJURED, 1, 1) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0,app.items[0].quality,"The minimum quality of a conjured item is 0");
	}

	@Test
	public void theMinimumQualityOfAConjuredItemIsZeroAfterExpiring17() {
		Item[] items = new Item[] { new Item(CONJURED, 0, 1) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0,app.items[0].quality,"The minimum quality of a conjured item is 0");
		assertEquals(-1,app.items[0].sellIn,"The conjured item expired");
	}

	@Test
	public void ifTheQualityWasZeroItStillIsAfterAnUpdate18() {
		Item[] items = new Item[] { new Item(CONJURED, 5, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0,app.items[0].quality,"The quality of the conjured item is still 0 after an update");
	}


	@Test
	public void everyItemShouldHaveTheExpectedQualityAfterFiveUpdates19() {
		Item[] items = new Item[] {
				new Item(CONJURED, 6, 11),
				new Item(SULFURAS, 6, 80),
				new Item(AGED_BRIE, 6, 35),
				new Item(NORMAL_ITEM, 6, 12),
				new Item(BACKSTAGE, 7, 21)
		};


		GildedRose app = new GildedRose(items);
		for (int i = 0; i < 5 ; i++) {
			app.updateQuality();
		}

		assertEquals(1,app.items[0].quality,"The quality of the conjured item should be 1");
		assertEquals(80,app.items[1].quality,"The quality of sulfuras is always 80");
		assertEquals(6,app.items[1].sellIn,"The sell in value of sulfuras is the same as the start");
		assertEquals(40,app.items[2].quality,"The quality of the aged brie is 40");
		assertEquals(7,app.items[3].quality,"The quality of the normal item is 7");
		assertEquals(34,app.items[4].quality,"The quality of the backstage item is 34");
	}


	@Test
	public void everyItemShouldHaveTheExpectedQualityAfterSixUpdates20() {
		Item[] items = new Item[] {
				new Item(CONJURED, 3, 11),
				new Item(SULFURAS, 3, 80),
				new Item(AGED_BRIE, 3, 35),
				new Item(NORMAL_ITEM, 3, 12),
				new Item(BACKSTAGE, 4, 21)
		};


		GildedRose app = new GildedRose(items);
		for (int i = 0; i < 6 ; i++) {
			app.updateQuality();
		}

		assertEquals(0,app.items[0].quality,"The quality of the conjured item should be 0");
		assertEquals(80,app.items[1].quality,"The quality of sulfuras is always 80");
		assertEquals(3,app.items[1].sellIn,"The sell in value of sulfuras is the same as the start");
		assertEquals(44,app.items[2].quality,"The quality of the aged brie is 44");
		assertEquals(3,app.items[3].quality,"The quality of the normal item is 3");
		assertEquals(0,app.items[4].quality,"The quality of the backstage item is 0");
	}

	@Test
	public void backstageItemsIncreaseInQualityBy3WhenThereAre5DaysOrLessForTheConcert21() {
		Item[] items = new Item[] { new Item(BACKSTAGE, 4, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(13,app.items[0].quality,"The quality of a backstage item increases by 3 when there are 4 days for the concert");
	}

	@Test
	public void backstageItemsIncreaseInQualityBy3WhenThereAre5DaysOrLessForTheConcert22() {
		Item[] items = new Item[] { new Item(BACKSTAGE, 1, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(13,app.items[0].quality,"The quality of a backstage item increases by 3 when there 1 day for the concert");
	}

	@Test
	public void backstageItemsIncreaseInQualityBy2WhenThereAre10DaysOrLessForTheConcert23() {
		Item[] items = new Item[] { new Item(BACKSTAGE, 10, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(12,app.items[0].quality,"The quality of a backstage item increases by 3 when there 1 day for the concert");
	}

	@Test
	public void backstageItemsIncreaseInQualityBy1IfThereAreMoreThanTenDaysForTheConcert24() {
		Item[] items = new Item[] { new Item(BACKSTAGE, 11, 10) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(11,app.items[0].quality,"The quality of a backstage item increases by 1 when there more than 10 days for the concert");
	}

}
