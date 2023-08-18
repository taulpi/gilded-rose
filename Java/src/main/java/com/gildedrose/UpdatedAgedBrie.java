package com.gildedrose;

class UpdatedAgedBrie implements UpdatedItem {
    private final UpdatedStandardSellIn updatedSellIn;
    private final UpdatedAgedBrieQuality updatedAgedBrieQuality;

    UpdatedAgedBrie(UpdatedStandardSellIn updatedSellIn, UpdatedAgedBrieQuality updatedAgedBrieQuality) {
        this.updatedSellIn = updatedSellIn;
        this.updatedAgedBrieQuality = updatedAgedBrieQuality;
    }

    @Override
    public int sellIn() {
        return updatedSellIn.value();
    }

    @Override
    public int quality() {
        return updatedAgedBrieQuality.value();
    }
}
