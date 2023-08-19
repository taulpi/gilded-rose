package com.gildedrose;

class UpdatedNormalQuality implements UpdatedQuality {
    private final int quality;
    private final QualityAdjustment qualityAdjustment;

    UpdatedNormalQuality(int quality, QualityAdjustment qualityAdjustment) {
        this.quality = quality;
        this.qualityAdjustment = qualityAdjustment;
    }

    @Override
    public int value() {
        return quality - qualityAdjustment.value();
    }

}
