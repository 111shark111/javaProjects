package com.example.geektrust.Service;

import com.example.geektrust.Utility.Constants;

public class CheckInService {

    private static CheckInService instance;
    private final CardService cardService = CardService.getInstance();
    private final SummaryService summaryService = SummaryService.getInstance();

    public static CheckInService getInstance(){
        if (instance == null) {
            instance = new CheckInService();
        }
        return instance;
    }

    public void doCheckIn(String metroCardId, String personTypeString, String destinationString) {
            String response = cardService.addCardDetails(metroCardId,personTypeString,destinationString);
            if(response.equals(Constants.CARD_NOT_FOUND)) return;
            Boolean isDiscountApplicable = response.equals(Constants.DISCOUNT_PRESENT);
            summaryService.updateCollection(isDiscountApplicable,personTypeString,metroCardId,destinationString);
    }
}

