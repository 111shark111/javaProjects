package com.example.geektrust.Service;

public class MainService {

    private final DriverService driverService = DriverService.getInstance();
    private final RiderService riderService =  RiderService.getInstance();
    private final MatchService matchService = MatchService.getInstance();
    private final RideService rideService = RideService.getInstance();
    private final BillService billService = BillService.getInstance();

    public void mainService(String[] parts){
        String command = parts[0];
        switch (command){
            case "ADD_DRIVER" : {
                driverService.addDriver(parts[1],parts[2],parts[3]);
                break;
            }
            case "ADD_RIDER":{
                riderService.addRider(parts[1],parts[2],parts[3]);
                break;
            }
            case "MATCH":{
                matchService.doMatchMaking(parts[1]);
                break;
            }
            case "START_RIDE":{
                rideService.startRide(parts[1],parts[2],parts[3]);
                break;
            }
            case "STOP_RIDE":{
                rideService.stopRide(parts[1],parts[2],parts[3],parts[4]);
                break;
            }
            case "BILL":{
                billService.generateBill(parts[1]);
                break;
            }
        }
    }


}
