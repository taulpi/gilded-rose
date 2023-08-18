package com.gildedrose;

class UpdatedLegendarySellIn implements UpdatedSellIn {
    private final int sellIn;

    UpdatedLegendarySellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    @Override
    public int value() {
        return sellIn;
    }
}
