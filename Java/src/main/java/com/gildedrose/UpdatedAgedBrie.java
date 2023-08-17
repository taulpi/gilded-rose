package com.gildedrose;

class UpdatedAgedBrie implements UpdatedItem {
    private Item item;

    public UpdatedAgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public int sellIn() {
        return item.sellIn - 1;
    }

    @Override
    public int quality() {
        int qualityIncrease = item.sellIn < 1 ? 2 : 1;
        return Math.min(50, item.quality + qualityIncrease);
    }
}
