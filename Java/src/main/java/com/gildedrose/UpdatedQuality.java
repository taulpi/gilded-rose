package com.gildedrose;

class UpdatedQuality {
    private int sellIn;
    private int quality;

    public UpdatedQuality(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int value() {
        int qualityDecrease = sellIn < 1 ? 2 : 1;
        return Math.max(0, quality - qualityDecrease);
    }
}
