package com.gildedrose;

class UpdatedConcertTicketQuality implements UpdatedQuality {
    private final int quality;
    private final int sellIn;

    UpdatedConcertTicketQuality(int quality, int sellIn) {
        this.quality = quality;
        this.sellIn = sellIn;
    }

    @Override
    public int value() {
        if (sellIn < 1) {
            return 0;
        }
        return Math.min(50, quality + qualityIncrease());
    }

    private int qualityIncrease() {
        if (sellIn < 6) {
            return 3;
        } else if (sellIn < 11) {
            return 2;
        }
        return 1;
    }
}
