package com.gildedrose;

class GildedRose {
    private final Item[] items;

    GildedRose(Item[] items) {
        this.items = items.clone();
    }

    void updateQuality() {
        for (Item item : items) {
            UpdatedItem updatedItem = updated(item);
            item.quality = updatedItem.quality();
            item.sellIn = updatedItem.sellIn();
        }
    }

    private UpdatedItem updated(Item item) {
        return switch (item.name) {
            case "Sulfuras, Hand of Ragnaros" -> new UpdatedItem(
                new UpdatedLegendaryQuality(),
                new UpdatedLegendarySellIn(item.sellIn));
            case "Aged Brie" -> new UpdatedItem(
                new CappedQuality(new UpdatedAgedBrieQuality(item.quality, item.sellIn)),
                new UpdatedStandardSellIn(item.sellIn));
            case "Backstage passes to a TAFKAL80ETC concert" -> new UpdatedItem(
                new CappedQuality(new UpdatedConcertTicketQuality(item.quality, item.sellIn)),
                new UpdatedStandardSellIn(item.sellIn));
            default -> new UpdatedItem(
                new CappedQuality(new UpdatedNormalQuality(item.sellIn, item.quality)),
                new UpdatedStandardSellIn(item.sellIn));
        };
    }

}
