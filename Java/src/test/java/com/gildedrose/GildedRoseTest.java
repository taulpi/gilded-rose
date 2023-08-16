package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "-1, 1",
    })
    void qualityDoesNotDecreaseBelow0(int sellIn, int quality) {
        Item item = new Item("Some non special Item", sellIn, quality);

        whenQualityIsUpdated(item);

        assertEquals(0, item.quality);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 50",
        "-1, 49",
    })
    void qualityDoesNotIncreaseOver50(int sellIn, int quality) {
        Item item = new Item("Aged Brie", sellIn, quality);

        whenQualityIsUpdated(item);

        assertEquals(50, item.quality);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 100, -1, -2, -3, -4, -5, -100})
    void sulfurasNeverHasToBeSold(int originalSellin) {
        Item item = new Item("Sulfuras, Hand of Ragnaros", originalSellin, 80);

        whenQualityIsUpdated(item);

        assertEquals(originalSellin, item.sellIn);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 100, -1, -2, -3, -4, -5, -100})
    void sulfurasNeverDecreasesInQuality(int sellIn) {
        Item item = new Item("Sulfuras, Hand of Ragnaros", sellIn, 80);

        whenQualityIsUpdated(item);

        assertEquals(80, item.quality);
    }

    @Test
    void qualityOfAllItemsIsAdjusted() {
        Item item1 = new Item("some Item", 1, 3);
        Item item2 = new Item("some Item", 4, 50);

        new GildedRose(new Item[]{item1, item2}).updateQuality();

        assertEquals(2, item1.quality);
        assertEquals(49, item2.quality);
    }

    @Test
    void sellInOfAllItemsIsAdjusted() {
        Item item1 = new Item("some Item", 1, 3);
        Item item2 = new Item("some Item", 4, 50);

        new GildedRose(new Item[]{item1, item2}).updateQuality();

        assertEquals(0, item1.sellIn);
        assertEquals(3, item2.sellIn);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 2, 0",
        "-1, 2, 0",
        "-2, 2, 0",
        "-100, 2, 0",
        "-1, 99, 97",
    })
    void onceTheSellByDateHasPassed_QualityDegradesTwiceAsFast(int sellIn, int quality, int expected) {
        Item item = new Item("some Item", sellIn, quality);

        whenQualityIsUpdated(item);

        assertEquals(expected, item.quality);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 0, 1",
        "1, 1, 2",
        "1, 49, 50",
        "-1, 0, 2",
        "-1, 1, 3",
        "-1, 48, 50",
    })
    void agedBrieIncreasesInQuality(int sellIn, int quality, int expected) {
        Item item = new Item("Aged Brie", sellIn, quality);

        whenQualityIsUpdated(item);

        assertEquals(expected, item.quality);
    }

    private void whenQualityIsUpdated(Item item) {
        new GildedRose(new Item[]{item}).updateQuality();
    }
}
