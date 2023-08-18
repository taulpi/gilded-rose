package com.gildedrose;

class UpdatedAgedBrieQuality implements UpdatedQuality {

    private final int quality;
    private final int sellIn;

    public UpdatedAgedBrieQuality(int quality, int sellIn) {
        this.quality = quality;
        this.sellIn = sellIn;
    }

    @Override
    public int value() {
        int qualityIncrease = sellIn < 1 ? 2 : 1;
        return Math.min(50, quality + qualityIncrease);
    }
}
