package com.gildedrose;

class UpdatedBackstageItem implements UpdatedItem {
    private Item item;
    private final UpdatedSellIn updatedSellIn;

    public UpdatedBackstageItem(Item item, UpdatedSellIn updatedSellIn) {
        this.item = item;
        this.updatedSellIn = updatedSellIn;
    }

    @Override
    public int sellIn() {
        return updatedSellIn.value();
    }

    @Override
    public int quality() {
        if (item.sellIn < 1) {
            return 0;
        }
        return Math.min(50, item.quality + qualityIncrease());
    }

    private int qualityIncrease() {
        if (item.sellIn < 6) {
            return 3;
        }
        if (item.sellIn < 11) {
            return 2;
        }
        return 1;
    }
}
