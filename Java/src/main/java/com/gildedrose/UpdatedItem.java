package com.gildedrose;

class UpdatedItem {
    private final UpdatedQuality updatedQuality;
    private final UpdatedSellIn updatedSellIn;

    UpdatedItem(UpdatedQuality updatedQuality, UpdatedSellIn updatedSellIn) {
        this.updatedQuality = updatedQuality;
        this.updatedSellIn = updatedSellIn;
    }

    int sellIn() {
        return updatedSellIn.value();
    }

    int quality() {
        return updatedQuality.value();
    }

}
