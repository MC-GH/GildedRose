package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            String name = item.name;

            if(name.equals("Backstage passes to a TAFKAL80ETC concert")) {

            }



            if (!name.equals("Aged Brie")
                    && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(item);
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
                            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(item);
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

    public void increaseQuality(Item item, int frequency) {
        for(int i = 0; i < frequency; i++) {
            increaseQuality(item);
        }
    }

    public void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    public void updateBackstagePassQuality(Item item) {
        int sellIn = item.sellIn;
        if(sellIn > 10) {
            increaseQuality(item);
        } else if (sellIn <= 10) {
            increaseQuality(item, 2);
        } else if (sellIn < 6) {
            increaseQuality(item,3);
        } else {
            item.quality = 0;
        }
    }

}