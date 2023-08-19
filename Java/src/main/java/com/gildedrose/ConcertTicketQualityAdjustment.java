package com.gildedrose;

class ConcertTicketQualityAdjustment implements QualityAdjustment {

    private final int oldSellIn;

    public ConcertTicketQualityAdjustment(int oldSellIn) {
        this.oldSellIn = oldSellIn;
    }

    @Override
    public int value() {
        if (oldSellIn < 6) {
            return 3;
        } else if (oldSellIn < 11) {
            return 2;
        }
        return 1;
    }
}
