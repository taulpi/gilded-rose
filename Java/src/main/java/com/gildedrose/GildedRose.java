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
        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return updatedLegendary(item);
        } else if ("Aged Brie".equals(item.name)) {
            return updatedAgedBrie(item);
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            return updatedBackstagePass(item);
        } else if ("Conjured".equals(item.name)) {
            return new UpdatedItem(new ConstantQuality(0), new UpdatedNormaSellIn(item.sellIn));
        }
        return updatedNormal(item);
    }

    private UpdatedItem updatedNormal(Item item) {
        return new UpdatedItem(
            new CappedQuality(new UpdatedNormalQuality(item.sellIn, item.quality)),
            new UpdatedNormaSellIn(item.sellIn));
    }

    private UpdatedItem updatedBackstagePass(Item item) {
        return new UpdatedItem(
            new CappedQuality(new UpdatedConcertTicketQuality(item.quality, item.sellIn)),
            new UpdatedNormaSellIn(item.sellIn));
    }

    private UpdatedItem updatedAgedBrie(Item item) {
        return new UpdatedItem(
            new CappedQuality(new UpdatedAgedBrieQuality(item.quality, item.sellIn)),
            new UpdatedNormaSellIn(item.sellIn));
    }

    private UpdatedItem updatedLegendary(Item item) {
        return new UpdatedItem(
            new ConstantQuality(80),
            new ConstantSellIn(item.sellIn));
    }

}
