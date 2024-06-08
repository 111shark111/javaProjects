package com.example.geektrust.Enums;

import com.example.geektrust.Utility.Constants;

public enum ProgramType {
    CERTIFICATION(Constants.CERTIFICATION_PRICE,Constants.PRO_MEMBERSHIP_DISCOUNT_CERTIFICATION),
    DEGREE(Constants.DEGREE_PRICE,Constants.PRO_MEMBERSHIP_DISCOUNT_DEGREE),
    DIPLOMA(Constants.DIPLOMA_PRICE,Constants.PRO_MEMBERSHIP_DISCOUNT_DIPLOMA),
    ;

    private final Integer price;
    private final Integer proMembershipDiscount;

    ProgramType(Integer price,Double discountPercentage) {
        this.price = price;
        this.proMembershipDiscount = (int) (price* discountPercentage);
    }
    public Integer getPrice(){
        return this.price;
    }

    public Integer getProMembershipDiscount() {
        return this.proMembershipDiscount;
    }
}
