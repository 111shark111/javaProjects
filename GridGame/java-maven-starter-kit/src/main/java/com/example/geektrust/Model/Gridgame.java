package com.example.geektrust.Model;

import com.example.geektrust.Utility.CommonUtils;
import com.example.geektrust.Utility.Constants;

public class Gridgame {
    private Integer power;
    private Source source;
    private Destination destination;
    public Gridgame(Source source, Destination destination) {
        this.power = Constants.INTIAL_PLAYER_POWER;
        this.source = source;
        this.destination = destination;
    }

    public void printPower() {
        Integer remainingPower = calculatePower();
        System.out.println(Constants.POWER + " " + remainingPower);
    }

    private Integer calculatePower() {
        Integer gridPointMovements = Math.abs(source.getxCordinate()-destination.getxCordinate());
        gridPointMovements+= Math.abs(source.getyCordinate()-destination.getyCordinate());
        Integer gridPointMovementPowerLapsed = gridPointMovements * Constants.POWER_FOR_MAKING_ONE_GRID_MOVE;
        Integer turnPointMovementPowerLapsed = CommonUtils.calculateTurnPointPowerLapsed(source,destination);
        return power-(gridPointMovementPowerLapsed + turnPointMovementPowerLapsed);
    }
}
