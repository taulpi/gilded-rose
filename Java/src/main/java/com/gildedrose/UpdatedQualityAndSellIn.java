package com.gildedrose;

class UpdatedQualityAndSellIn implements UpdatedItem {
    private final UpdatedQuality updatedQuality;
    private final UpdatedSellIn updatedSellIn;

    public UpdatedQualityAndSellIn(UpdatedQuality updatedQuality, UpdatedSellIn updatedSellIn) {
        this.updatedQuality = updatedQuality;
        this.updatedSellIn = updatedSellIn;
    }

    @Override
    public int sellIn() {
        return updatedSellIn.value();
    }

    @Override
    public int quality() {
        return updatedQuality.value();
    }

}
