package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private void whenQualityIsUpdated(Item item) {
        new GildedRose(new Item[]{item}).updateQuality();
    }

    @Nested
    class TheSellIn {
        @ParameterizedTest(name = "sellIn={0}, updatedSellIn={1}")
        @CsvSource({
            "0, -1",
            "2, 1",
            "1, 0",
            "999, 998",
            "-1, -2",
            "-111, -112",
        })
        void isDecreased(int sellIn, int expected) {
            Item item = new Item("some Item", sellIn, 0);

            whenQualityIsUpdated(item);

            assertEquals(expected, item.sellIn);
        }

        @Test
        void ofAllItemsIsAdjusted() {
            Item item1 = new Item("some Item", 1, 3);
            Item item2 = new Item("some Item", 4, 50);

            new GildedRose(new Item[]{item1, item2}).updateQuality();

            assertEquals(0, item1.sellIn);
            assertEquals(3, item2.sellIn);
        }
    }

    @Nested
    class TheQuality {
        @ParameterizedTest(name = "quality={0}, updatedQuality={1}")
        @CsvSource({
            "2, 1",
            "1, 0",
            "50, 49",
        })
        void isDecreased(int quality, int expected) {
            Item item = new Item("some Item", 5, quality);

            whenQualityIsUpdated(item);

            assertEquals(expected, item.quality);
        }

        @ParameterizedTest(name = "sellIn={0}, quality={1}")
        @CsvSource({
            "0, 0",
            "-1, 1",
        })
        void doesNotDecreaseBelow0(int sellIn, int quality) {
            Item item = new Item("Some non special Item", sellIn, quality);

            whenQualityIsUpdated(item);

            assertEquals(0, item.quality);
        }

        @Test
        void ofAllItemsIsAdjusted() {
            Item item1 = new Item("some Item", 1, 3);
            Item item2 = new Item("some Item", 4, 50);

            new GildedRose(new Item[]{item1, item2}).updateQuality();

            assertEquals(2, item1.quality);
            assertEquals(49, item2.quality);
        }

        @ParameterizedTest(name = "sellIn={0} , quality={1}, updatedQuality={2}")
        @CsvSource({
            "0, 2, 0",
            "-1, 2, 0",
            "-2, 2, 0",
            "-100, 2, 0",
            "-1, 50, 48",
        })
        void degradesTwiceAsFast_onceTheSellByDateHasPassed(int sellIn, int quality, int expected) {
            Item item = new Item("some Item", sellIn, quality);

            whenQualityIsUpdated(item);

            assertEquals(expected, item.quality);
        }
    }


    @Nested
    class AgedBrieQuality {

        @ParameterizedTest(name = "sellIn={0} , quality={1}, updatedQuality={2}")
        @CsvSource({
            "1, 0, 1",
            "1, 1, 2",
            "1, 49, 50",
            "-1, 0, 2",
            "-1, 1, 3",
            "-1, 48, 50",
        })
        void increases(int sellIn, int quality, int expected) {
            Item item = new Item("Aged Brie", sellIn, quality);

            whenQualityIsUpdated(item);

            assertEquals(expected, item.quality);
        }

        @ParameterizedTest(name = "sellIn={0} , quality={1}")
        @CsvSource({
            "1, 50",
            "-1, 49",
        })
        void doesNotIncreaseOver50(int sellIn, int quality) {
            Item item = new Item("Aged Brie", sellIn, quality);

            whenQualityIsUpdated(item);

            assertEquals(50, item.quality);
        }

    }

    @Nested
    class BackstagePassQuality {

        @ParameterizedTest(name = "sellIn={0}")
        @ValueSource(ints = {11, 12, 20, 30, 40, 50})
        void increases_asItsSellInValueApproaches(int sellIn) {
            Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 10);

            whenQualityIsUpdated(item);

            assertEquals(11, item.quality);
        }

        @ParameterizedTest(name = "sellIn={0}")
        @ValueSource(ints = {6, 7, 8, 9, 10})
        void increases_twice_AsItsSellInUnder10(int sellIn) {
            Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 10);

            whenQualityIsUpdated(item);

            assertEquals(12, item.quality);
        }

        @ParameterizedTest(name = "sellIn={0}")
        @ValueSource(ints = {1, 2, 3, 4, 5})
        void increases_thrice_AsItsSellInUnder10(int sellIn) {
            Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 10);

            whenQualityIsUpdated(item);

            assertEquals(13, item.quality);
        }

        @ParameterizedTest(name = "sellIn={0}")
        @ValueSource(ints = {0, -1, -5, -100})
        void is0_whenSellIn0OrLower(int sellIn) {
            Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 10);

            whenQualityIsUpdated(item);

            assertEquals(0, item.quality);
        }
    }

    @Nested
    class Sulfuras {
        @ParameterizedTest(name = "sellIn={0}")
        @ValueSource(ints = {1, 2, 3, 4, 5, 100, -1, -2, -3, -4, -5, -100})
        void sellIn_neverDecreases(int originalSellin) {
            Item item = new Item("Sulfuras, Hand of Ragnaros", originalSellin, 80);

            whenQualityIsUpdated(item);

            assertEquals(originalSellin, item.sellIn);
        }

        @ParameterizedTest(name = "sellIn={0}")
        @ValueSource(ints = {1, 2, 3, 4, 5, 100, -1, -2, -3, -4, -5, -100})
        void quality_neverDecreases(int sellIn) {
            Item item = new Item("Sulfuras, Hand of Ragnaros", sellIn, 80);

            whenQualityIsUpdated(item);

            assertEquals(80, item.quality);
        }
    }

}
