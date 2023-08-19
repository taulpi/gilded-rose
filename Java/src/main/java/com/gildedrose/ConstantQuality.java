package com.gildedrose;

class ConstantQuality implements UpdatedQuality {

    private int quality;

    ConstantQuality(int quality1) {
        this.quality = quality1;
    }

    @Override
    public int value() {
        return quality;
    }
}
