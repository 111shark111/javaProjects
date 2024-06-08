package com.example.geektrust.Service;

public class MainService {

    SubscriptionService subscriptionService = SubscriptionService.getInstance();
    TopUpService topUpService = TopUpService.getInstance();
    SummaryService summaryService = SummaryService.getInstance();

    public void mainService(String[] parts) {
        String command = parts[0];
        switch (command){
            case "START_SUBSCRIPTION" : {
                subscriptionService.startSubscription(parts[1]);
                break;
            }
            case "ADD_SUBSCRIPTION":{
                subscriptionService.addSubscription(parts[1],parts[2]);
                break;
            }
            case "ADD_TOPUP":{
                topUpService.addTopUp(parts[1],parts[2]);
                break;
            }
            case "PRINT_RENEWAL_DETAILS":{
                summaryService.printRenewalSummary();
                break;
            }
        }
    }
}
