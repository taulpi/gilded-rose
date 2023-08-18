package com.gildedrose;

class UpdatedSulfuras implements UpdatedItem {
    private Item item;
    private UpdatedLegendaryQuality updatedLegendaryQuality;

    public UpdatedSulfuras(Item item, UpdatedLegendaryQuality updatedLegendaryQuality) {
        this.item = item;
        this.updatedLegendaryQuality = updatedLegendaryQuality;
    }

    @Override
    public int sellIn() {
        return item.sellIn;
    }

    @Override
    public int quality() {
        return updatedLegendaryQuality.value();
    }

}
