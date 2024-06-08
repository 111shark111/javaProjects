package com.example.geektrust.Service;

import com.example.geektrust.Utility.Constants;

public class MainService {


    private final CardService cardService = CardService.getInstance();
    private final CheckInService checkInService =  CheckInService.getInstance();
    private final SummaryService summaryService = SummaryService.getInstance();

    public void mainService(String[] parts){
        String command = parts[0];
        switch (command){
            case (Constants.BALANCE)  : {
                cardService.addCard(parts[1],parts[2]);
                break;
            }
            case (Constants.CHECK_IN):{
                checkInService.doCheckIn(parts[1],parts[2],parts[3]);
                break;
            }
            case (Constants.PRINT_SUMMARY):{
                summaryService.printSummary();
                break;
            }
        }
    }


}