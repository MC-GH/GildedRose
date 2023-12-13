package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            String name = item.name;

            if (!name.equals("Aged Brie")
                    && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(item);
                    }
                }
            } else {
                increaseQuality(item);
                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                            increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                            increaseQuality(item);
                    }
                }
            }

            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseSellIn(item);
            }

            if (item.sellIn < 0) {
                if (!name.equals("Aged Brie")) {
                    if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(item);
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                        increaseQuality(item);
                }
            }
        }
    }

    public void decreaseQuality(Item item) {
        if (item.quality > 0) item.quality--;
    }

    public void increaseQuality(Item item) {
        if (item.quality < 50) item.quality++;
    }

    public void decreaseSellIn(Item item) {
        item.sellIn--;
    }

}