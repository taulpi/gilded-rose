package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void theSellinIsIncreased() {
        Item item = new Item("Some non special Item", 0, 0);

        whenQualityIsUpdated(item);

        assertEquals(-1, item.sellIn);

    }
    @Test
    void qualityDoesNotDecreaseBelow0() {
        Item item = new Item("Some non special Item", 0, 0);

        whenQualityIsUpdated(item);

        assertEquals(0, item.quality);
    }

    private void whenQualityIsUpdated(Item item) {
        new GildedRose(new Item[]{item}).updateQuality();
    }
}
