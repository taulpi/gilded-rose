package com.gildedrose;

class UpdatedSulfuras implements UpdatedItem {
    private UpdatedLegendaryQuality updatedQuality;
    private UpdatedLegendarySellIn updatedSellIn;

    public UpdatedSulfuras(UpdatedLegendaryQuality updatedQuality, UpdatedLegendarySellIn updatedSellIn) {
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
