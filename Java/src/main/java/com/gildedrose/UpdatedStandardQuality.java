package com.gildedrose;

class UpdatedStandardQuality implements UpdatedQuality {
    private final int sellIn;
    private final int quality;

    UpdatedStandardQuality(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public int value() {
        int qualityDecrease = sellIn < 1 ? 2 : 1;
        return Math.max(0, quality - qualityDecrease);
    }
}
