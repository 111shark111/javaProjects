package com.example.geektrust.Service;

import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Model.Summary;
import com.example.geektrust.Utility.CommonUtils;
import com.example.geektrust.Utility.Constants;

public class SummaryService {

    private static SummaryService instance;
    private final CardService cardService = CardService.getInstance();
    private Summary airportSummary = new Summary(Constants.AIRPORT);
    private Summary centralSummary = new Summary(Constants.CENTRAL);

    public static SummaryService getInstance(){
        if (instance == null) {
            instance = new SummaryService();
        }
        return instance;
    }

    public void updateCollection(Boolean isDiscountPresent, String personType, String metroCardId, String destinationString){
        Double fareAmount = CommonUtils.getGeneralFairAmount(personType);
        Double discountGiven = 0.0;
        // discount case -50%
        // fare is not enough +2% of total charge
        // case of adult , kid or senior_citizen
        // add to Airport or Central
        if(isDiscountPresent){
            discountGiven = fareAmount * Constants.DISCOUNT_PERCENTAGE;
            fareAmount -= discountGiven;
        }
        MetroCard metroCard = cardService.getMetroCard(metroCardId);
        if(fareAmount > metroCard.getBalance()){
            fareAmount = fareAmount + (fareAmount - metroCard.getBalance()) * Constants.SERVICE_FEE;
            metroCard.setBalance(0);
        }
        else metroCard.setBalance((int) (metroCard.getBalance() - fareAmount));

        cardService.updateCard(metroCard);
        if(destinationString.equals(Constants.AIRPORT)){
            airportSummary.setTotalCollection((int) (airportSummary.getTotalCollection() + fareAmount));
            airportSummary.setDiscountGiven((int) (airportSummary.getDiscountGiven() + discountGiven));
            airportSummary.setNumberOfAdults(airportSummary.getNumberOfAdults() +(personType.equals(Constants.ADULT)?1:0) );
            airportSummary.setNumberOfKids(airportSummary.getNumberOfKids() +(personType.equals(Constants.KID)?1:0) );
            airportSummary.setNumberOfSeniorCitizens(airportSummary.getNumberOfSeniorCitizens() +(personType.equals(Constants.SENIOR_CITIZEN)?1:0) );
        }
        else{
            centralSummary.setTotalCollection((int) (centralSummary.getTotalCollection() + fareAmount));
            centralSummary.setDiscountGiven((int) (centralSummary.getDiscountGiven() + discountGiven));
            centralSummary.setNumberOfAdults(centralSummary.getNumberOfAdults() +(personType.equals(Constants.ADULT)?1:0) );
            centralSummary.setNumberOfKids(centralSummary.getNumberOfKids() +(personType.equals(Constants.KID)?1:0) );
            centralSummary.setNumberOfSeniorCitizens(centralSummary.getNumberOfSeniorCitizens() +(personType.equals(Constants.SENIOR_CITIZEN)?1:0) );
        }
    }

    public void printSummary() {
        centralSummary.printRequiredSummary();
        airportSummary.printRequiredSummary();
    }
}
