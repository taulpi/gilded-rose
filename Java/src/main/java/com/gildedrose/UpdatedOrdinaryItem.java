package com.gildedrose;

class UpdatedOrdinaryItem implements UpdatedItem {
    private final UpdatedStandardSellIn updatedSellIn;
    private final UpdatedQuality updatedQuality;

    public UpdatedOrdinaryItem(UpdatedStandardSellIn updatedSellIn, UpdatedQuality updatedQuality) {
        this.updatedSellIn = updatedSellIn;
        this.updatedQuality = updatedQuality;
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
