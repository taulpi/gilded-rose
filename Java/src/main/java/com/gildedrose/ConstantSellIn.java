package com.gildedrose;

class ConstantSellIn implements UpdatedSellIn {
    private final int oldSellIn;

    ConstantSellIn(int oldSellIn) {
        this.oldSellIn = oldSellIn;
    }

    @Override
    public int value() {
        return oldSellIn;
    }
}
