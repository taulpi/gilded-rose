package com.gildedrose;

class NormalQualityAdjustment implements QualityAdjustment {

    private final int sellIn;

    NormalQualityAdjustment(int sellIn) {
        this.sellIn = sellIn;
    }

    @Override
    public int value() {
        return sellIn < 1 ? -2 : -1;
    }
}
