package com.gildedrose;

class UpdatedLegendarySellIn implements UpdatedSellIn {
    private final int oldSellIn;

    UpdatedLegendarySellIn(int oldSellIn) {
        this.oldSellIn = oldSellIn;
    }

    @Override
    public int value() {
        return oldSellIn;
    }
}
