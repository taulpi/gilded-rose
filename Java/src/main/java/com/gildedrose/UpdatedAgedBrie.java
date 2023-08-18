package com.gildedrose;

class UpdatedAgedBrie implements UpdatedItem {
    private Item item;
    private final UpdatedStandardSellIn updatedSellIn;

    public UpdatedAgedBrie(Item item, UpdatedStandardSellIn updatedSellIn) {
        this.item = item;
        this.updatedSellIn = updatedSellIn;
    }

    @Override
    public int sellIn() {
        return updatedSellIn.value();
    }

    @Override
    public int quality() {
        int qualityIncrease = item.sellIn < 1 ? 2 : 1;
        return Math.min(50, item.quality + qualityIncrease);
    }
}
