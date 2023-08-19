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
        if (concertAlreadyHappened()) {
            return 0;
        }
        return oldQuality + qualityIncrease();
    }

    private boolean concertAlreadyHappened() {
        return oldSellIn < 1;
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
