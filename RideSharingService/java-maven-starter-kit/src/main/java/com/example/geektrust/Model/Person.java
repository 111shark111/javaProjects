package com.example.geektrust.Model;

public class Person {

    private String id;
    private Integer xCordinate;
    private Integer yCordinate;
    private Boolean isOccupied;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getxCordinate() {
        return xCordinate;
    }

    public void setxCordinate(Integer xCordinate) {
        this.xCordinate = xCordinate;
    }

    public Integer getyCordinate() {
        return yCordinate;
    }

    public void setyCordinate(Integer yCordinate) {
        this.yCordinate = yCordinate;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }
}
