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
        return switch (item.name) {
            case "Sulfuras, Hand of Ragnaros" -> new UpdatedQualityAndSellIn(
                new UpdatedLegendaryQuality(),
                new UpdatedLegendarySellIn(item.sellIn));
            case "Aged Brie" -> new UpdatedQualityAndSellIn(
                new UpdatedAgedBrieQuality(item.quality, item.sellIn),
                new UpdatedStandardSellIn(item.sellIn));
            case "Backstage passes to a TAFKAL80ETC concert" -> new UpdatedQualityAndSellIn(
                new UpdatedConcertTicketQuality(item.quality, item.sellIn),
                new UpdatedStandardSellIn(item.sellIn));
            default -> new UpdatedQualityAndSellIn(
                new UpdatedStandardQuality(item.sellIn, item.quality),
                new UpdatedStandardSellIn(item.sellIn));
        };
    }

}
