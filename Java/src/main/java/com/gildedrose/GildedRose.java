package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.quality = updatedQuality(item);
            item.sellIn = updatedSellIn(item);
        }
    }

    private int updatedSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return item.sellIn - 1;
        } else {
            return item.sellIn;
        }
    }

    private int updatedQuality(Item item) {
        int updatedQuality = item.quality;
        if (!item.name.equals("Aged Brie")
            && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    updatedQuality--;
                }
            }
        } else {
            if (updatedQuality < 50) {
                updatedQuality++;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (updatedQuality < 50) {
                            updatedQuality++;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (updatedQuality < 50) {
                            updatedQuality++;
                        }
                    }
                }
            }
        }


        if (item.sellIn < 1) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (updatedQuality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
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
        return updatedQuality;
    }
}
