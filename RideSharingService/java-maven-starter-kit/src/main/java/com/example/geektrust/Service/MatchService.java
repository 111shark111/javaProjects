package com.example.geektrust.Service;



import com.example.geektrust.Model.Person;
import com.example.geektrust.Utility.Constants;

import java.util.HashMap;
import java.util.List;

public class MatchService {

    RiderService riderService = RiderService.getInstance();
    DriverService driverService = DriverService.getInstance();
    private HashMap<String,List<String>> matches = new HashMap<>();
    private static MatchService instance;

    public static MatchService getInstance() {
        if (instance == null) {
            instance = new MatchService();
        }
        return instance;
    }

    public void doMatchMaking(String riderId){
        Person rider = riderService.getRider(riderId);
        if(rider != null){
           List<String> requiredDrivers =  driverService.getAllDrivers(rider.getxCordinate(),rider.getyCordinate());
           if(requiredDrivers==null || requiredDrivers.isEmpty()){
               System.out.println(Constants.NO_DRIVERS_AVAILABLE);
               return;
           }
           matches.put(riderId,requiredDrivers);
           StringBuilder toBePrinted = new StringBuilder(Constants.DRIVERS_MATCHED + " ");
            for (String requiredDriver : requiredDrivers) {
                toBePrinted.append(requiredDriver).append(" ");
            }
           System.out.println(toBePrinted);
        }
        else{
            System.out.println(Constants.INVALID_RIDER_ID);
        }
    }

    public List<String> getMatchedRiders(String riderId){
        return matches.get(riderId);
    }
}
