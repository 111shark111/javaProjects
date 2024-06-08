package com.example.geektrust.Service;

import com.example.geektrust.Enums.CategoryName;
import com.example.geektrust.Enums.PlansName;
import com.example.geektrust.Model.ErrorMessage;
import com.example.geektrust.Model.Subscription;
import com.example.geektrust.Utility.Constants;
import com.example.geektrust.Utility.DateFormatter;

import java.util.Date;
import java.util.HashMap;

public class SubscriptionService {

    private static SubscriptionService subscriptionService = null;
    private static Date subscriptionStartDate = null;
    private static HashMap<CategoryName,Subscription> subscriptions = new HashMap<>();

    public static SubscriptionService getInstance() {
        if(subscriptionService == null){
            subscriptionService =  new SubscriptionService();
            return subscriptionService;
        }
        else return subscriptionService;
    }

    public void startSubscription(String dateString) {
        try{
            subscriptionStartDate = DateFormatter.getDateFromString(dateString);
            if(subscriptionStartDate == null){
                ErrorMessage.setErrorMessage(Constants.INVALID_DATE);
                ErrorMessage.printMessage("");
            }
        }
        catch(Exception e){
            ErrorMessage.setErrorMessage(Constants.INVALID_DATE);
            ErrorMessage.printMessage("");
            return ;
        }

    }

    public void addSubscription(String subcriptionCategoryString, String planNameString) {

        if(ErrorMessage.getErrorMessage() != null){
            ErrorMessage.printMessage(Constants.ADD_SUBSCRIPTION_FAILED);
            return;
        }
        CategoryName categoryName = CategoryName.valueOf(subcriptionCategoryString);
        PlansName plansName = PlansName.valueOf(planNameString);
        Subscription subscription = new Subscription(categoryName,plansName);
        if(subscriptions.containsKey(categoryName)){
            ErrorMessage.setErrorMessage(Constants.DUPLICATE_CATEGORY);
            ErrorMessage.printMessage(Constants.ADD_SUBSCRIPTION_FAILED);
        }
        else subscriptions.put(categoryName,subscription);
    }

    public static Date getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public static HashMap<CategoryName, Subscription> getSubscriptions() {
        return subscriptions;
    }
}
