package com.gildedrose;

class UpdatedStandardSellIn implements UpdatedSellIn {
    private final int oldSellIn;

    UpdatedStandardSellIn(int oldSellIn) {
        this.oldSellIn = oldSellIn;
    }

    @Override
    public int value() {
        return oldSellIn - 1;
    }
}
