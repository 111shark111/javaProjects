package com.example.geektrust.Model;

import com.example.geektrust.Enums.TopUpType;

public class TopUpModel {
    private TopUpType topUpType;
    private Integer duration;
    private Integer totalPrice;

    public TopUpModel(TopUpType topUpType, Integer duration) {
        this.topUpType = topUpType;
        this.duration = duration;
        this.totalPrice = topUpType.getUnitPrice() * duration;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }
}
