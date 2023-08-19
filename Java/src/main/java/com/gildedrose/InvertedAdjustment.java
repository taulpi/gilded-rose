package com.gildedrose;

class InvertedAdjustment implements QualityAdjustment {

    private final QualityAdjustment adjustment;

    InvertedAdjustment(QualityAdjustment adjustment) {
        this.adjustment = adjustment;
    }

    @Override
    public int value() {
        return adjustment.value() * -1;
    }
}
