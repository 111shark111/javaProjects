package com.example.geektrust.Service;

import com.example.geektrust.Model.Person;

import java.util.*;

public class RiderService {
    private HashMap<String,Person> allRiders = new HashMap<>();
    private static RiderService instance;

    public static RiderService getInstance(){
        if (instance == null) {
            instance = new RiderService();
        }
        return instance;
    }

    public void addRider(String id, String xCordinate, String yCordinate){
        Person rider = new Person();
        rider.setId(id);
        rider.setxCordinate(Integer.parseInt(xCordinate));
        rider.setyCordinate(Integer.parseInt(yCordinate));
        allRiders.put(id,rider);
    }

    public Person getRider(String riderId) {
        return allRiders.getOrDefault(riderId, null);
    }
}
