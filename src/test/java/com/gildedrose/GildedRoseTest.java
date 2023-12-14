package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

//    @Test
//    void foo() {
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("foo", app.items[0].name);
//    }

    @Test
    void QualityDecreaseBy1() {
        Item[] items = new Item[] { new Item("Butter", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void SellInDecreaseBy1() {
        Item[] items = new Item[] { new Item("Butter", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4,app.items[0].sellIn);
    }

    @Test
    void DoubleDegradationWhenSellIn0() {
        Item[] items = new Item[] { new Item("Butter", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8,app.items[0].quality);
    }

    @Test
    void QualityNotNegative() {
        Item[] items = new Item[] { new Item("Butter", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    //Special cases:
    @Test
    void AgedBrieIncreasesQualityBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11,app.items[0].quality);
    }

    @Test
    void AgedBrieQualityNotOver50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void SulfurasNoChangeQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15,app.items[0].quality);
    }

    @Test
    void SulfurasNoChangeSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15,app.items[0].quality);
    }

    @Test
    void BackstagePassesIncreasesQualityBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16,app.items[0].quality);
    }

    @Test
    void BackstagePassesIncreasesQualityBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17,app.items[0].quality);
    }

    @Test
    void BackstagePassesIncreasesQualityBy3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18,app.items[0].quality);
    }

    @Test
    void BackstagePassesQualityDrops0WhenSellInPassed() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void BackstagePassesQualityIncreaseBy3OnDayOfSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18,app.items[0].quality);
    }

    @Test
    void ConjuredItemDoubleDegradation() {
        Item[] items = new Item[] { new Item("Conjured item", 2, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13,app.items[0].quality);
    }

    @Test
    void ConjuredItemDoubleDegradationNotBelow0() {
        Item[] items = new Item[] { new Item("Conjured item", 2, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void ConjuredItemAlsoDecreaseSellIn() {
        Item[] items = new Item[] { new Item("Conjured item", 2, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1,app.items[0].sellIn);
    }

}
