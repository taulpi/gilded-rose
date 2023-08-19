package com.gildedrose;

class UpdatedAgedBrieQuality implements UpdatedQuality {

    private final int oldQuality;
    private final QualityAdjustment qualityAdjustment;

    UpdatedAgedBrieQuality(int oldQuality, QualityAdjustment qualityAdjustment) {
        this.oldQuality = oldQuality;
        this.qualityAdjustment = qualityAdjustment;
    }

    @Override
    public int value() {
        return oldQuality + qualityAdjustment.value();
    }
}
