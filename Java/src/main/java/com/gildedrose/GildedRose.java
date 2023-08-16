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
            int updatedQuality = item.quality;
            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    updatedQuality--;
                }
            } else {
                if (updatedQuality < 50) {
                    updatedQuality++;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (updatedQuality < 50) {
                                updatedQuality++;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (updatedQuality < 50) {
                                updatedQuality++;
                            }
                        }
                    }
                }
            }


            if (item.sellIn < 1) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (updatedQuality > 0) {
                        updatedQuality--;
                    }
                } else {
                    updatedQuality -= updatedQuality;
                }
            }
            return updatedQuality;
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
            int updatedQuality = item.quality;
            if (updatedQuality < 50) {
                updatedQuality++;

                if (item.sellIn < 11) {
                    if (updatedQuality < 50) {
                        updatedQuality++;
                    }
                }

                if (item.sellIn < 6) {
                    if (updatedQuality < 50) {
                        updatedQuality++;
                    }
                }
            }


            if (item.sellIn < 1) {
                updatedQuality -= updatedQuality;
            }
            return updatedQuality;
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
            int updatedQuality = item.quality;
            if (updatedQuality < 50) {
                updatedQuality++;
            }


            if (item.sellIn < 1) {
                if (updatedQuality < 50) {
                    updatedQuality++;
                }
            }
            return updatedQuality;
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
            int updatedQuality = item.quality;
            if (updatedQuality < 50) {
                updatedQuality++;
            }
            return updatedQuality;
        }
    }
}
