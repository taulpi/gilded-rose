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
            return new UpdatedSulfuras(new UpdatedLegendaryQuality(), new UpdatedLegendarySellIn(item.sellIn));
        }
        if (item.name.equals("Aged Brie")) {
            return new UpdatedAgedBrie(item, new UpdatedSellIn(item.sellIn));
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new UpdatedBackstageItem(item, new UpdatedSellIn(item.sellIn));
        }

        return new UpdatedOrdinaryItem(new UpdatedSellIn(item.sellIn), new UpdatedQuality(item.sellIn, item.quality));
    }

}
