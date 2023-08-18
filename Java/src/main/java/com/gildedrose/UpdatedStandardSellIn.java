package com.gildedrose;

class UpdatedStandardSellIn implements UpdatedSellIn {
    private final int sellIn;

    public UpdatedStandardSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    @Override
    public int value() {
        return sellIn - 1;
    }
}
