package com.gildedrose;

class UpdatedBackstageItem implements UpdatedItem {
    private Item item;
    private final UpdatedStandardSellIn updatedSellIn;

    public UpdatedBackstageItem(Item item, UpdatedStandardSellIn updatedSellIn) {
        this.item = item;
        this.updatedSellIn = updatedSellIn;
    }

    @Override
    public int sellIn() {
        return updatedSellIn.value();
    }

    @Override
    public int quality() {
        int sellIn = item.sellIn;
        int quality = item.quality;

        return new UpdatedConcertTicketQuality(quality, sellIn).value();
    }

}
