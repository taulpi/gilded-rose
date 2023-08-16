package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @ParameterizedTest
    @CsvSource({
        "0, -1",
        "2, 1",
        "1, 0",
        "999, 998",
        "-1, -2",
        "-111, -112",
    })
    void theSellinIsDecreased(int sellIn, int expected) {
        Item item = new Item("some Item", sellIn, 0);

        whenQualityIsUpdated(item);

        assertEquals(expected, item.sellIn);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1",
        "1, 0",
        "999, 998",
    })
    void qualityIsDecreased(int quality, int expected) {
        Item item = new Item("some Item", 5, quality);

        whenQualityIsUpdated(item);

        assertEquals(expected, item.quality);
    }

    @Test
    void qualityDoesNotDecreaseBelow0() {
        Item item = new Item("Some non special Item", 0, 0);

        whenQualityIsUpdated(item);

        assertEquals(0, item.quality);
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 2, 0",
        "-2, 2, 0",
        "-100, 2, 0",
        "-1, 99, 97",
    })
    void once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast(int sellIn, int quality, int expected) {
        Item item = new Item("some Item", sellIn, quality);

        whenQualityIsUpdated(item);

        assertEquals(expected, item.quality);
    }

    private void whenQualityIsUpdated(Item item) {
        new GildedRose(new Item[]{item}).updateQuality();
    }
}
