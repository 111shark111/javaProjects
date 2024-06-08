package com.example.geektrust.Model;

import com.example.geektrust.Enums.DirectionType;

public class Source {
    private Integer xCordinate = 0;
    private Integer yCordinate = 0;
    private DirectionType directionType = DirectionType.NONE;

    public Source(String xCordinateString, String yCordinateString, String direction) {
        this.xCordinate = Integer.parseInt(xCordinateString);
        this.yCordinate = Integer.parseInt(yCordinateString);
        this.directionType = DirectionType.valueOf(direction);
    }

    public Integer getxCordinate() {
        return xCordinate;
    }

    public Integer getyCordinate() {
        return yCordinate;
    }

    public DirectionType getDirectionType() {
        return directionType;
    }
}
