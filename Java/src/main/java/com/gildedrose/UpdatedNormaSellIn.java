package com.gildedrose;

class UpdatedNormaSellIn implements UpdatedSellIn {
    private final int oldSellIn;

    UpdatedNormaSellIn(int oldSellIn) {
        this.oldSellIn = oldSellIn;
    }

    @Override
    public int value() {
        return oldSellIn - 1;
    }
}
