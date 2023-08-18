package com.gildedrose;

class UpdatedConcertTicketQuality implements UpdatedQuality {
    private final int oldQuality;
    private final int oldSellIn;

    UpdatedConcertTicketQuality(int oldQuality, int oldSellIn) {
        this.oldQuality = oldQuality;
        this.oldSellIn = oldSellIn;
    }

    @Override
    public int value() {
        if (oldSellIn < 1) {
            return 0;
        }
        return Math.min(50, oldQuality + qualityIncrease());
    }

    private int qualityIncrease() {
        if (oldSellIn < 6) {
            return 3;
        } else if (oldSellIn < 11) {
            return 2;
        }
        return 1;
    }
}