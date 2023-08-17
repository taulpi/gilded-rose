package com.gildedrose;

class UpdatedBackstageItem implements UpdatedItem {
    private Item item;

    public UpdatedBackstageItem(Item item) {
        this.item = item;
    }

    @Override
    public int sellIn() {
        return item.sellIn - 1;
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
