package com.example.geektrust.Enums;

import com.example.geektrust.Utility.Constants;

public enum PlansName {
    FREE(Constants.FREE_PLAN_DURATION_IN_MONTH),
    PERSONAL(Constants.PERSONAL_PLAN_DURATION_IN_MONTH),
    PREMIUM(Constants.PREMIUM_PLAN_DURATION_IN_MONTH);

    private final int durationInMonth;

    PlansName(int planDurationInMonth) {
        this.durationInMonth = planDurationInMonth;
    }
    public int getDurationInMonth(){
        return this.durationInMonth;
    }
}
