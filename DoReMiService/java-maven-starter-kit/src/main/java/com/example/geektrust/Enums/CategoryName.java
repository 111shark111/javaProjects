package com.example.geektrust.Enums;

import com.example.geektrust.Utility.Constants;

public enum CategoryName {
    MUSIC(Constants.FREE_PLAN_PRICE,Constants.PERSONAL_PLAN_MUSIC_PRICE,Constants.PREMIUM_PLAN_MUSIC_PRICE),
    PODCAST(Constants.FREE_PLAN_PRICE,Constants.PERSONAL_PLAN_PODCAST_PRICE,Constants.PREMIUM_PLAN_PODCAST_PRICE),
    VIDEO(Constants.FREE_PLAN_PRICE,Constants.PERSONAL_PLAN_VIDEO_PRICE,Constants.PREMIUM_PLAN_VIDEO_PRICE);

    private final int freePlanPrice;
    private final int personalPlanPrice;
    private final int premiumPlanPrice;

    CategoryName(int freePlanPrice, int personalPlanPrice, int premiumPlanPrice) {
        this.freePlanPrice = freePlanPrice;
        this.personalPlanPrice = personalPlanPrice;
        this.premiumPlanPrice = premiumPlanPrice;
    }

    public int getPrice(PlansName planName) {
        switch (planName) {
            case FREE:
                return freePlanPrice;
            case PREMIUM:
                return premiumPlanPrice;
            case PERSONAL:
                return personalPlanPrice;
            default:
                throw new IllegalArgumentException("Unknown plan name: " + planName);
        }
    }
}
