package com.example.geektrust.Service;

import com.example.geektrust.Enum.RideStatus;
import com.example.geektrust.Model.Person;
import com.example.geektrust.Model.Ride;
import com.example.geektrust.Utility.CommonUtils;
import com.example.geektrust.Utility.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class RideService {
    private HashMap<String,Ride> allRides = new HashMap<>();
    private static RideService instance;
    private final MatchService matchService = MatchService.getInstance();
    private final DriverService driverService = DriverService.getInstance();
    private final RiderService riderService = RiderService.getInstance();

    public static RideService getInstance() {
        if (instance == null) {
            instance = new RideService();
        }
        return instance;
    }

    public Ride createRide(String rideId){
        if(allRides.containsKey(rideId)){
            return null;
        }
        Ride ride = new Ride();
        ride.setId(rideId);
        return ride;
    }

    public void startRide(String rideId, String n, String riderId){
        Ride ride = createRide(rideId);
        if(ride == null){
            System.out.println(Constants.INVALID_RIDE);
            return;
        }
        Integer count = Integer.parseInt(n);
        List<String> requiredDrivers = matchService.getMatchedRiders(riderId);
        if(requiredDrivers == null || requiredDrivers.size() < count){
            System.out.println(Constants.INVALID_RIDE);
            return;
        }
        String driverId = requiredDrivers.get(count-1);
        Person driver = driverService.getDriver(driverId);
        if(driver.getOccupied().equals(Boolean.FALSE)){
            ride.setStatus(RideStatus.STARTED.toString());
            ride.setDriverId(driverId);
            ride.setRiderId(riderId);
            driver.setOccupied(Boolean.TRUE);
            driverService.updateDriver(driver);
            allRides.put(rideId,ride);
            System.out.println(Constants.RIDE_STARTED +" "+rideId);
        }
        else{
            System.out.println(Constants.INVALID_RIDE);
        }
        return;
    }
    public void stopRide(String rideId, String destinationX, String destinationY, String timeTakenInMinutes){
        // ride flag completed , driver released , rider released
        Ride ride = allRides.get(rideId);
        if(ride == null || Objects.equals(ride.getStatus(), RideStatus.STOPPED.toString())){
            System.out.println(Constants.INVALID_RIDE);
            return;
        }
        ride.setStatus(RideStatus.STOPPED.toString());
        String riderId = ride.getRiderId();
        Person rider = riderService.getRider(riderId);
        Integer xCordinateDestination = Integer.parseInt(destinationX);
        Integer yCordinateDestination = Integer.parseInt(destinationY);
        Integer totalTime = Integer.parseInt(timeTakenInMinutes);
        Double distance = CommonUtils.calculateDistance(xCordinateDestination,yCordinateDestination, rider.getxCordinate(), rider.getyCordinate());
        ride.setDistance(distance);
        ride.setTotalTime(totalTime);
        String driverId = ride.getDriverId();
        Person driver = driverService.getDriver(driverId);
        driver.setOccupied(Boolean.FALSE);
        driverService.updateDriver(driver);
        allRides.put(rideId,ride);
        System.out.println(Constants.RIDE_STOPPED+" "+ rideId);

    }

    public Ride getRide(String rideId) {
        return allRides.get(rideId);
    }
}
