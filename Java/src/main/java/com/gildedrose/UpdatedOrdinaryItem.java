package com.gildedrose;

class UpdatedOrdinaryItem implements UpdatedItem {
    private final Item item;
    private UpdatedSellIn updatedSellIn;

    public UpdatedOrdinaryItem(Item item, UpdatedSellIn updatedSellIn) {
        this.item = item;
        this.updatedSellIn = updatedSellIn;
    }

    @Override
    public int sellIn() {
        return updatedSellIn.value();
    }

    @Override
    public int quality() {
        int qualityDecrease = item.sellIn < 1 ? 2 : 1;
        return Math.max(0, item.quality - qualityDecrease);
    }

}
