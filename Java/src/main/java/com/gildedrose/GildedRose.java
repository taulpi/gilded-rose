package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdatedItem updatedItem = updated(item);
            item.quality = updatedItem.quality();
            item.sellIn = updatedItem.sellIn();
        }
    }

    private UpdatedItem updated(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new UpdatedSellInAndQuality(new UpdatedLegendaryQuality(), new UpdatedLegendarySellIn(item.sellIn));
        }
        if (item.name.equals("Aged Brie")) {
            return new UpdatedAgedBrie(item, new UpdatedStandardSellIn(item.sellIn));
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new UpdatedBackstageItem(item, new UpdatedStandardSellIn(item.sellIn));
        }

        return new UpdatedSellInAndQuality(
            new UpdatedStandardQuality(item.sellIn, item.quality),
            new UpdatedStandardSellIn(item.sellIn));
    }

}
