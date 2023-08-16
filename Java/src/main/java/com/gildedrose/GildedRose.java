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
            return new OrdinaryUpdatedItem.UpdatedSulfuras(item);
        }
        return new OrdinaryUpdatedItem(item);
    }

    private static class OrdinaryUpdatedItem implements UpdatedItem {
        private Item item;

        public OrdinaryUpdatedItem(Item item) {
            this.item = item;
        }

        @Override
        public int sellIn() {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return item.sellIn;
            } else {
                return item.sellIn - 1;
            }
        }

        @Override
        public int quality() {
            int updatedQuality = item.quality;
            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        updatedQuality--;
                    }
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
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (updatedQuality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                updatedQuality--;
                            }
                        }
                    } else {
                        updatedQuality -= updatedQuality;
                    }
                } else {
                    if (updatedQuality < 50) {
                        updatedQuality++;
                    }
                }
            }
            return updatedQuality;
        }

        private static class UpdatedSulfuras implements UpdatedItem {
            private Item item;

            public UpdatedSulfuras(Item item) {
                this.item = item;
            }

            @Override
            public int sellIn() {
                if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    return item.sellIn;
                } else {
                    return item.sellIn - 1;
                }
            }

            @Override
            public int quality() {
                int updatedQuality = item.quality;
                if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            updatedQuality--;
                        }
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
                    if (!item.name.equals("Aged Brie")) {
                        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (updatedQuality > 0) {
                                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                    updatedQuality--;
                                }
                            }
                        } else {
                            updatedQuality -= updatedQuality;
                        }
                    } else {
                        if (updatedQuality < 50) {
                            updatedQuality++;
                        }
                    }
                }
                return updatedQuality;
            }
        }
    }
}
