package com.gildedrose;

class UpdatedOrdinaryItem implements UpdatedItem {
    private Item item;

    public UpdatedOrdinaryItem(Item item) {
        this.item = item;
    }

    @Override
    public int sellIn() {
        return item.sellIn - 1;
    }

    @Override
    public int quality() {
        int qualityDecrease = item.sellIn < 1 ? 2 : 1;
        return Math.max(0, item.quality - qualityDecrease);
    }
}
