package com.gildedrose;

class UpdatedOrdinaryItem implements UpdatedItem {
    private final UpdatedSellIn updatedSellIn;
    private final UpdatedQuality updatedQuality;

    public UpdatedOrdinaryItem(UpdatedSellIn updatedSellIn, UpdatedQuality updatedQuality) {
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
