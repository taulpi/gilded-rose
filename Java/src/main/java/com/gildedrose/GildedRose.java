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
        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new UpdatedQualityAndSellIn(
                new UpdatedLegendaryQuality(),
                new UpdatedLegendarySellIn(item.sellIn));
        }
        if ("Aged Brie".equals(item.name)) {
            return new UpdatedQualityAndSellIn(
                new UpdatedAgedBrieQuality(item.quality, item.sellIn),
                new UpdatedStandardSellIn(item.sellIn));
        }
        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            return new UpdatedQualityAndSellIn(
                new UpdatedConcertTicketQuality(item.quality, item.sellIn),
                new UpdatedStandardSellIn(item.sellIn));
        }
        return new UpdatedQualityAndSellIn(
            new UpdatedStandardQuality(item.sellIn, item.quality),
            new UpdatedStandardSellIn(item.sellIn));
    }

}
