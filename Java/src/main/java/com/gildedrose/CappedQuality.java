package com.gildedrose;

class CappedQuality implements UpdatedQuality {

    private final UpdatedQuality updatedQuality;

    CappedQuality(UpdatedQuality updatedQuality) {
        this.updatedQuality = updatedQuality;
    }

    @Override
    public int value() {
        int value = updatedQuality.value();
        if (value > 50) {
            return 50;
        }
        return Math.max(value, 0);
    }
}
