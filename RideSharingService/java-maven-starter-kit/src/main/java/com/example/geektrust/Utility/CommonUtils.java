package com.example.geektrust.Utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommonUtils {

    public static Double generateRequiredValue(Double value){
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2,RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static Double calculateDistance(Integer x1,Integer y1,Integer x2,Integer y2){
        Double distance;
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return generateRequiredValue(distance);
    }

    public static Double generateBill(Double distance, Integer totalTime) {
        Double bill = Constants.BASE_FARE;
        bill += (Constants.DISTANCE_FARE * distance);
        bill += (Constants.TIME_FARE * totalTime);
        bill += (bill * Constants.SERVICE_TAX);
        return generateRequiredValue(bill);
    }
}
