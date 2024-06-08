package com.example.geektrust.Utility;

import com.example.geektrust.Enums.DirectionType;
import com.example.geektrust.Model.Destination;
import com.example.geektrust.Model.Source;

public class CommonUtils {
    public static Integer calculateTurnPointPowerLapsed(Source source, Destination destination) {
        Integer turnPoints = 0;
        if(source.getDirectionType().equals(DirectionType.N)){
            if(destination.getyCordinate() > source.getyCordinate()){
                turnPoints++;
            }
            else turnPoints+=Constants.TWO_TURNS_MOVE;
        }
        else if(source.getDirectionType().equals(DirectionType.S)){
            if(destination.getyCordinate() > source.getyCordinate()){
                turnPoints+=Constants.TWO_TURNS_MOVE;
            }
            else turnPoints++;

        }
        else if(source.getDirectionType().equals(DirectionType.E)){
            if(destination.getxCordinate() < source.getxCordinate()){
                turnPoints+=Constants.TWO_TURNS_MOVE;
            }
            else turnPoints++;
        }
        else{
            if(destination.getxCordinate() < source.getxCordinate()){
                turnPoints++;
            }
            else turnPoints+=Constants.TWO_TURNS_MOVE;
        }
        return turnPoints * Constants.POWER_FOR_MAKING_ONE_TURN;
    }
}
