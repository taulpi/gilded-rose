package com.gildedrose;

class UpdatedAgedBrieQuality implements UpdatedQuality {

    private final int oldQuality;
    private final int oldSellIn;

    UpdatedAgedBrieQuality(int oldQuality, int oldSellIn) {
        this.oldQuality = oldQuality;
        this.oldSellIn = oldSellIn;
    }

    @Override
    public int value() {
        int qualityIncrease = oldSellIn < 1 ? 2 : 1;
        return Math.min(50, oldQuality + qualityIncrease);
    }
}
