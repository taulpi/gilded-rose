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
            case "Sulfuras, Hand of Ragnaros" -> updatedLegendary(item);
            case "Aged Brie" -> updatedAgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> updatedBackstagePass(item);
            default -> updatedNormal(item);
        };
    }

    private UpdatedItem updatedNormal(Item item) {
        return new UpdatedItem(
            new CappedQuality(new UpdatedNormalQuality(item.sellIn, item.quality)),
            new UpdatedStandardSellIn(item.sellIn));
    }

    private UpdatedItem updatedBackstagePass(Item item) {
        return new UpdatedItem(
            new CappedQuality(new UpdatedConcertTicketQuality(item.quality, item.sellIn)),
            new UpdatedStandardSellIn(item.sellIn));
    }

    private UpdatedItem updatedAgedBrie(Item item) {
        return new UpdatedItem(
            new CappedQuality(new UpdatedAgedBrieQuality(item.quality, item.sellIn)),
            new UpdatedStandardSellIn(item.sellIn));
    }

    private UpdatedItem updatedLegendary(Item item) {
        return new UpdatedItem(
            new ConstantQuality(80),
            new ConstantSellIn(item.sellIn));
    }

}
