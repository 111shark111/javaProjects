package com.example.geektrust.Enums;

import com.example.geektrust.Utility.Constants;

public enum TopUpType {
    FOUR_DEVICE(Constants.FOUR_DEVICE_UNIT_PRICE),
    TEN_DEVICE(Constants.TEN_DEVICE_UNIT_PRICE);

    private final int unitPrice;
    TopUpType(int unitPrice) {
        this.unitPrice = unitPrice;

    }
    public int getUnitPrice() {
        return unitPrice;
    }


}
