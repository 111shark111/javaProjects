package com.example.geektrust.Service;


import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Utility.Constants;

import java.util.HashMap;

public class CardService {
    private HashMap<String, MetroCard> allMetroCards = new HashMap<>();
    private static CardService instance;

    public static CardService getInstance(){
        if (instance == null) {
            instance = new CardService();
        }
        return instance;
    }

    public void addCard(String id, String balanceString) {
        MetroCard metroCard = new MetroCard();
        metroCard.setId(id);
        Integer balance = Integer.parseInt(balanceString);
        metroCard.setBalance(balance);
        allMetroCards.put(id,metroCard);
        return;
    }

    public MetroCard getMetroCard(String metroCardId) {
        return allMetroCards.getOrDefault(metroCardId, null);
    }

    public String addCardDetails(String metroCardId, String personTypeString, String destinationString) {
        MetroCard metroCard = allMetroCards.get(metroCardId);
        if(metroCard != null){
            metroCard.setPersonType(personTypeString);
            Integer airportCount = metroCard.getCountAirport();
            Integer centralCount = metroCard.getCountCental();
            Boolean isDiscountApplicable = false;
            if(!airportCount.equals(centralCount)){
                isDiscountApplicable = true;
            }
            if(destinationString.equals(Constants.AIRPORT)){
                metroCard.setCountAirport(airportCount+1);
            }
            else{
                metroCard.setCountCental(centralCount+1);
            }
            return isDiscountApplicable ? Constants.DISCOUNT_PRESENT : Constants.DISCOUNT_NOT_PRESENT;
       }
        else{
            return Constants.CARD_NOT_FOUND;
        }
    }

    public void updateCard(MetroCard metroCard) {
      allMetroCards.put(metroCard.getId(),metroCard);
    }
}
