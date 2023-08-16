package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            int updatedQuality = items[i].quality;
            int updatedSellIn = items[i].sellIn;
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        updatedQuality = updatedQuality - 1;
                    }
                }
            } else {
                if (updatedQuality < 50) {
                    updatedQuality = updatedQuality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (updatedSellIn < 11) {
                            if (updatedQuality < 50) {
                                updatedQuality = updatedQuality + 1;
                            }
                        }

                        if (updatedSellIn < 6) {
                            if (updatedQuality < 50) {
                                updatedQuality = updatedQuality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                updatedSellIn = updatedSellIn - 1;
            }

            if (updatedSellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (updatedQuality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                updatedQuality = updatedQuality - 1;
                            }
                        }
                    } else {
                        updatedQuality = updatedQuality - updatedQuality;
                    }
                } else {
                    if (updatedQuality < 50) {
                        updatedQuality = updatedQuality + 1;
                    }
                }
            }
            items[i].quality = updatedQuality;
            items[i].sellIn = updatedSellIn;
        }
    }
}
