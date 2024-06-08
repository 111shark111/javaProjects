package com.example.geektrust.Service;


import com.example.geektrust.Enums.CategoryName;
import com.example.geektrust.Model.ErrorMessage;
import com.example.geektrust.Model.Subscription;
import com.example.geektrust.Utility.Constants;
import com.example.geektrust.Utility.DateFormatter;

import java.util.HashMap;
import java.util.Map;

public class SummaryService {
    private static SummaryService summaryService = null;

    public static SummaryService getInstance() {
        if(summaryService == null){
            summaryService =  new SummaryService();
            return summaryService;
        }
        else return summaryService;
    }

    public void printRenewalSummary() {
        Integer sumOfAllSubscriptions = 0;
        Integer totalPrice = 0;
        HashMap<CategoryName, Subscription> requiredMap =  SubscriptionService.getSubscriptions();
        if(requiredMap.isEmpty()){
            ErrorMessage.setErrorMessage(Constants.SUBSCRIPTIONS_NOT_FOUND);
            ErrorMessage.printMessage("");
        }
        else{
//            if(ErrorMessage.getErrorMessage() != null){
//                ErrorMessage.printMessage();
//                return;
//            }
            sumOfAllSubscriptions = getAndPrintPriceOfSubscription(requiredMap);
            totalPrice = sumOfAllSubscriptions;
            if(TopUpService.getTopUp() != null){
                totalPrice+=  TopUpService.getTopUp().getTotalPrice();
            }
            System.out.println(Constants.RENEWAL_AMOUNT + " " + totalPrice);
        }
    }

    private Integer getAndPrintPriceOfSubscription(HashMap<CategoryName, Subscription> requiredMap) {
        Integer sumOfAllSubscriptions = 0;
        Subscription requiredSubscription = null;
        if(requiredMap.containsKey(CategoryName.valueOf(Constants.MUSIC))){
            requiredSubscription = requiredMap.get(CategoryName.valueOf(Constants.MUSIC));
            sumOfAllSubscriptions += requiredSubscription.getPlanPrice();
            System.out.println(Constants.RENEWAL_REMINDER + " " + Constants.MUSIC + " " + DateFormatter.getStringFromDate(requiredSubscription.getRenewalDate()));
        }
        if(requiredMap.containsKey(CategoryName.valueOf(Constants.VIDEO))){
            requiredSubscription = requiredMap.get(CategoryName.valueOf(Constants.VIDEO));
            sumOfAllSubscriptions += requiredSubscription.getPlanPrice();
            System.out.println(Constants.RENEWAL_REMINDER  + " " + Constants.VIDEO + " " + DateFormatter.getStringFromDate(requiredSubscription.getRenewalDate()));

        }
        if(requiredMap.containsKey(CategoryName.valueOf(Constants.PODCAST))){
            requiredSubscription = requiredMap.get(CategoryName.valueOf(Constants.PODCAST));
            sumOfAllSubscriptions += requiredSubscription.getPlanPrice();
            System.out.println(Constants.RENEWAL_REMINDER  + " " + Constants.PODCAST + " " + DateFormatter.getStringFromDate(requiredSubscription.getRenewalDate()));
        }
        return sumOfAllSubscriptions;
    }
}
