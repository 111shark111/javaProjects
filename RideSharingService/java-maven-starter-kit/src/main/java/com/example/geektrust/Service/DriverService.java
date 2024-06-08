package com.example.geektrust.Service;

import com.example.geektrust.Model.Person;
import com.example.geektrust.Utility.CommonUtils;
import com.example.geektrust.Utility.Constants;

import java.util.*;

public class DriverService {

    private HashMap<String, Person> allDrivers = new HashMap<>();
    private static DriverService instance;

    public static DriverService getInstance(){
        if (instance == null) {
            instance = new DriverService();
        }
        return instance;
    }


    public void addDriver(String id, String xCordinate, String yCordinate){
        Person driver = new Person();
        driver.setId(id);
        driver.setOccupied(false);
        driver.setxCordinate(Integer.parseInt(xCordinate));
        driver.setyCordinate(Integer.parseInt(yCordinate));
        allDrivers.put(id,driver);
    }


    public List<String> getAllDrivers(Integer riderX, Integer riderY) {
        List<HashMap.Entry<Double, String>> list = new ArrayList<>();
        List<String> requiredDrivers = new ArrayList<>();
        if(allDrivers.isEmpty()){
            return requiredDrivers;
        }
        allDrivers.values().forEach(driver -> {
            if(driver.getOccupied().equals(Boolean.FALSE)){
                Double distance =  CommonUtils.calculateDistance(riderX,riderY, driver.getxCordinate(), driver.getyCordinate());
                list.add(new AbstractMap.SimpleEntry<>(distance, driver.getId()));
            }
        });
           list.sort((entry1 , entry2)->{
               int compareFirst = entry1.getKey().compareTo(entry2.getKey());
               if (compareFirst != 0) {
                   return compareFirst;
               } else {
                   return entry1.getValue().compareTo(entry2.getValue());
               }
           });
           list.forEach(element -> {
               if(element.getKey() <= Constants.DISTANCE_THRESHOLD) {
                   requiredDrivers.add(element.getValue());
               }
           });
           return requiredDrivers;
    }

    public Person getDriver(String driverId) {
        Person driver = null;
        if(allDrivers.containsKey(driverId)){
            driver =  allDrivers.get(driverId);
        }
        return driver;
    }

    public void updateDriver(Person driver) {
        String driverId = driver.getId();
        if(allDrivers.containsKey(driverId)){
            allDrivers.put(driverId,driver);
        }
    }
}
