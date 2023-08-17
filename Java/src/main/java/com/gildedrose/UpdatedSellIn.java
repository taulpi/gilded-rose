package com.gildedrose;

class UpdatedSellIn {
    private int sellIn;

    public UpdatedSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int value() {
        return sellIn - 1;
    }
}
