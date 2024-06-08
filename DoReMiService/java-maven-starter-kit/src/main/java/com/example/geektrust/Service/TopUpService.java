package com.example.geektrust.Service;

import com.example.geektrust.Enums.TopUpType;
import com.example.geektrust.Model.ErrorMessage;
import com.example.geektrust.Model.TopUpModel;
import com.example.geektrust.Utility.Constants;

public class TopUpService {

    private static TopUpService topUpService = null;
    private static TopUpModel topUp = null;

    public static TopUpService getInstance() {
        if(topUpService == null){
            topUpService =  new TopUpService();
            return topUpService;
        }
        else return topUpService;
    }

    public void addTopUp(String topUpNameString, String numberOfMonthsString) {
        if(ErrorMessage.getErrorMessage() == Constants.INVALID_DATE){
            ErrorMessage.printMessage(Constants.ADD_TOPUP_FAILED);
            return;
        }
        if(SubscriptionService.getSubscriptions().isEmpty()){
            ErrorMessage.setErrorMessage(Constants.SUBSCRIPTIONS_NOT_FOUND);
            ErrorMessage.printMessage(Constants.ADD_TOPUP_FAILED);
        }
        else{
            if(topUp == null){
                TopUpType topUpType = TopUpType.valueOf(topUpNameString);
                Integer duration = Integer.parseInt(numberOfMonthsString);
                topUp = new TopUpModel(topUpType,duration);
            }
            else{
                ErrorMessage.setErrorMessage(Constants.DUPLICATE_TOPUP);
                ErrorMessage.printMessage(Constants.ADD_TOPUP_FAILED);
            }
        }
    }

    public static TopUpModel getTopUp() {
        return topUp;
    }
}
