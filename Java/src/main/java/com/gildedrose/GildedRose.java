package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            int updatedQuality = items[i].quality;
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        updatedQuality--;
                    }
                }
            } else {
                if (updatedQuality < 50) {
                    updatedQuality++;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (updatedQuality < 50) {
                                updatedQuality++;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (updatedQuality < 50) {
                                updatedQuality++;
                            }
                        }
                    }
                }
            }


            if (items[i].sellIn < 1) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (updatedQuality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                updatedQuality--;
                            }
                        }
                    } else {
                        updatedQuality -= updatedQuality;
                    }
                } else {
                    if (updatedQuality < 50) {
                        updatedQuality++;
                    }
                }
            }
            items[i].quality = updatedQuality;

            int updatedSellIn = items[i].sellIn;
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                updatedSellIn--;
            }
            items[i].sellIn = updatedSellIn;
        }
    }
}
