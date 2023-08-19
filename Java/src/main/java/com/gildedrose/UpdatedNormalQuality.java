package com.gildedrose;

class UpdatedNormalQuality implements UpdatedQuality {
    private final int sellIn;
    private final int quality;

    UpdatedNormalQuality(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public int value() {
        int qualityDecrease = sellIn < 1 ? 2 : 1;
        return quality - qualityDecrease;
    }
}
