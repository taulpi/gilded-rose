package com.gildedrose;

class UpdatedSulfuras implements UpdatedItem {
    private Item item;

    public UpdatedSulfuras(Item item) {
        this.item = item;
    }

    @Override
    public int sellIn() {
        return item.sellIn;
    }

    @Override
    public int quality() {
        return 80;
    }
}
