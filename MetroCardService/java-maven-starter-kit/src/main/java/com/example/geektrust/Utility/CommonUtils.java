package com.example.geektrust.Utility;

import java.util.*;

public class CommonUtils {
    public static Double getGeneralFairAmount(String personType) {
        Double fare = 1.0;
        if(personType.equals(Constants.ADULT)){
            fare = fare * Constants.ADULT_FARE;
        }
        else if(personType.equals(Constants.KID)){
            fare = fare * Constants.KID_FARE;
        }
        else fare = fare * Constants.SENIOR_CITIZEN_FARE;
        return fare;
    }

    public static List<HashMap.Entry<Integer,String>> getRequiredOutputList(Integer numberOfAdults, Integer numberOfKids, Integer numberOfSeniorCitizens) {
        List<HashMap.Entry<Integer,String>> requiredList = new ArrayList<>();
        requiredList.add(new AbstractMap.SimpleEntry<>(numberOfAdults, Constants.ADULT));
        requiredList.add(new AbstractMap.SimpleEntry<>(numberOfKids, Constants.KID));
        requiredList.add(new AbstractMap.SimpleEntry<>(numberOfSeniorCitizens, Constants.SENIOR_CITIZEN));
        requiredList.sort((entry1,entry2)->{
            int compareFirst = entry2.getKey().compareTo(entry1.getKey());
            if (compareFirst != 0) {
                return compareFirst;
            } else {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        return requiredList;
    }
}
