package com.gildedrose;

class UpdatedSulfuras implements UpdatedItem {
    private final UpdatedQuality updatedQuality;
    private final UpdatedSellIn updatedSellIn;

    public UpdatedSulfuras(UpdatedQuality updatedQuality, UpdatedSellIn updatedSellIn) {
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
