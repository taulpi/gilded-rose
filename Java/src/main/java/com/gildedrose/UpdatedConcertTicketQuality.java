package com.gildedrose;

class UpdatedConcertTicketQuality implements UpdatedQuality {
    private final int oldQuality;
    private final int oldSellIn;
    private final QualityAdjustment qualityAdjustment;

    UpdatedConcertTicketQuality(int oldQuality, int oldSellIn, QualityAdjustment qualityAdjustment) {
        this.oldQuality = oldQuality;
        this.oldSellIn = oldSellIn;
        this.qualityAdjustment = qualityAdjustment;
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
        return qualityAdjustment.value();
    }

}
