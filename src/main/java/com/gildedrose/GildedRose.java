package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            String name = item.name;

            if (name.equals("Sulfuras, Hand of Ragnaros")) continue;

            if (name.startsWith("Conjured")) {
                decreaseQuality(item, 2);
            } else {
                switch (name) {
                    case "Backstage passes to a TAFKAL80ETC concert":
                        updateBackstagePassQuality(item);
                        break;
                    case "Aged Brie":
                        increaseQuality(item);
                        break;
                    default:
                        decreaseQuality(item);
                        break;
                }
            }

            decreaseSellIn(item);
        }
    }


    public void decreaseQuality(Item item) {
        if (item.quality > 0) item.quality--;
        if (item.quality > 0 && item.sellIn <= 0) item.quality--;
    }

    public void decreaseQuality(Item item, int frequency) {
        for (int i = 0; i < frequency; i++) {
            decreaseQuality(item);
        }
    }

    public void increaseQuality(Item item) {
        if (item.quality < 50) item.quality++;
    }

    public void increaseQuality(Item item, int frequency) {
        for (int i = 0; i < frequency; i++) {
            increaseQuality(item);
        }
    }

    public void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    public void updateBackstagePassQuality(Item item) {
        int sellIn = item.sellIn;

        if (sellIn > 10) {
            increaseQuality(item);
        } else if (sellIn > 5) {
            increaseQuality(item, 2);
        } else if (sellIn >= 0) {
            increaseQuality(item, 3);
        } else {
            item.quality = 0;
        }
    }

}