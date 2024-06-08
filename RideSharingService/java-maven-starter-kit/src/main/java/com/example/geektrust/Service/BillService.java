package com.example.geektrust.Service;

import com.example.geektrust.Enum.RideStatus;
import com.example.geektrust.Model.Ride;
import com.example.geektrust.Utility.CommonUtils;
import com.example.geektrust.Utility.Constants;

public class BillService {

    RideService rideService = RideService.getInstance();
    private static BillService instance;

    public static BillService getInstance(){
        if (instance == null) {
            instance = new BillService();
        }
        return instance;
    }

    public void generateBill(String rideId){
        Ride ride = rideService.getRide(rideId);
        if(ride == null){
            System.out.println(Constants.INVALID_RIDE);
            return;
        }
        if(ride.getStatus() != RideStatus.STOPPED.toString()){
            System.out.println(Constants.RIDE_NOT_COMPLETED);
            return;
        }
        Double distance = ride.getDistance();
        Integer totalTime = ride.getTotalTime();
        Double generatedBill = CommonUtils.generateBill(distance,totalTime);
        System.out.println(Constants.BILL +" " + rideId + " " + ride.getDriverId() + " " + String.format("%.2f", generatedBill));
    }
}
