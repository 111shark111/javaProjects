package com.example.geektrust.Model;

import com.example.geektrust.Enums.CategoryName;
import com.example.geektrust.Enums.PlansName;
import com.example.geektrust.Utility.DateFormatter;

import java.util.Date;

public class Subscription {
    private CategoryName categoryName;
    private PlansName plansName;
    private Integer planPrice;
    private Integer durationInMonths ;
    private Date renewalDate;

    public Subscription(CategoryName categoryName, PlansName plansName) {
        this.categoryName = categoryName;
        this.plansName = plansName;
        this.planPrice = categoryName.getPrice(plansName);
        this.durationInMonths = plansName.getDurationInMonth();
        this.renewalDate = DateFormatter.getRenewalReminderDate(this.durationInMonths);
    }
    public Date getRenewalDate() {
        return renewalDate;
    }

    public Integer getPlanPrice() {
        return planPrice;
    }
}
