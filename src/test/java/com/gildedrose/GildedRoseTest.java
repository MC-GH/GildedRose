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
    void updateQualityDecreasesQuality() {
        Item[] items = new Item[] { new Item("Butter", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void updateQualityDecreasesSellIn() {
        Item[] items = new Item[] { new Item("Butter", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4,app.items[0].sellIn);
    }

    @Test
    void updateQualityOnSellIn0dayDoubleDegradation() {
        Item[] items = new Item[] { new Item("Butter", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8,app.items[0].quality);
    }

    @Test
    void updateQualityQualityNotNegative() {
        Item[] items = new Item[] { new Item("Butter", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    //Special cases:
    @Test
    void updateQualityAgedBrieIncreasesQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11,app.items[0].quality);
    }

    @Test
    void updateQualityAgedBrieQualityNotOver50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void updateQualitySulfurasNoChangeQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15,app.items[0].quality);
    }

    @Test
    void updateQualitySulfurasNoChangeSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15,app.items[0].quality);
    }

    @Test
    void updateQualityBackstagePassesIncreasesQualityBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16,app.items[0].quality);
    }

    @Test
    void updateQualityBackstagePassesIncreasesQualityBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17,app.items[0].quality);
    }

    @Test
    void updateQualityBackstagePassesIncreasesQualityBy3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18,app.items[0].quality);
    }

    @Test
    void updateQualityBackstagePassesQualityDrops0WhenSellInPassed() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void updateQualityBackstagePassesIncreasesQualityBy3OnDayOfSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18,app.items[0].quality);
    }

    @Test
    void updateQualityConjuredItemDoubleDegradation() {
        Item[] items = new Item[] { new Item("Conjured item", 2, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13,app.items[0].quality);
    }

}
