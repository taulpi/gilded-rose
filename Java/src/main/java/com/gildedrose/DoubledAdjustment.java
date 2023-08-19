package com.gildedrose;

class DoubledAdjustment implements QualityAdjustment {

    private final QualityAdjustment adjustment;

    DoubledAdjustment(QualityAdjustment adjustment) {
        this.adjustment = adjustment;
    }

    @Override
    public int value() {
        return adjustment.value() * 2;
    }
}
