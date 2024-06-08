package com.example.geektrust.Model;

import com.example.geektrust.Enums.DirectionType;

public class Destination {
    private Integer xCordinate = 0;
    private Integer yCordinate = 0;

    public Destination(String xCordinateString, String yCordinateString) {
        this.xCordinate = Integer.parseInt(xCordinateString);
        this.yCordinate = Integer.parseInt(yCordinateString);
    }

    public Integer getxCordinate() {
        return xCordinate;
    }

    public Integer getyCordinate() {
        return yCordinate;
    }
}
