package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdatedItem updatedItem = updated(item);
            item.quality = updatedItem.quality();
            item.sellIn = updatedItem.sellIn();
        }
    }

    private UpdatedItem updated(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new UpdatedSulfuras(item);
        }
        if (item.name.equals("Aged Brie")) {
            return new UpdatedAgedBrie(item);
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new UpdatedBackstageItem(item);
        }

        return new UpdatedOrdinaryItem(item);
    }

    private static class UpdatedOrdinaryItem implements UpdatedItem {
        private Item item;

        public UpdatedOrdinaryItem(Item item) {
            this.item = item;
        }

        @Override
        public int sellIn() {
            return item.sellIn - 1;
        }

        @Override
        public int quality() {
            int qualityDecrease = item.sellIn < 1 ? 2 : 1;
            return Math.max(0, item.quality - qualityDecrease);
        }
    }

    private static class UpdatedBackstageItem implements UpdatedItem {
        private Item item;

        public UpdatedBackstageItem(Item item) {
            this.item = item;
        }

        @Override
        public int sellIn() {
            return item.sellIn - 1;
        }

        @Override
        public int quality() {
            if (item.sellIn < 1) {
                return 0;
            }
            return Math.min(50, item.quality + qualityIncrease());
        }

        private int qualityIncrease() {
            if (item.sellIn < 6) {
                return 3;
            }
            if (item.sellIn < 11) {
                return 2;
            }
            return 1;
        }
    }

    private static class UpdatedAgedBrie implements UpdatedItem {
        private Item item;

        public UpdatedAgedBrie(Item item) {
            this.item = item;
        }

        @Override
        public int sellIn() {
            return item.sellIn - 1;
        }

        @Override
        public int quality() {
            int qualityIncrease = item.sellIn < 1 ? 2 : 1;
            return Math.min(50, item.quality + qualityIncrease);
        }
    }

    private static class UpdatedSulfuras implements UpdatedItem {
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
}
