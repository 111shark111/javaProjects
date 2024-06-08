package com.example.geektrust.Model;



public class MetroCard {
    private Integer balance;
    private String id;
    private Integer countAirport;
    private Integer countCental;
    private String personType;

    public MetroCard() {
        this.id = "";
        this.countAirport=0;
        this.countCental=0;
        this.balance=0;
        this.personType="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getCountAirport() {
        return countAirport;
    }

    public void setCountAirport(Integer countAirport) {
        this.countAirport = countAirport;
    }

    public Integer getCountCental() {
        return countCental;
    }

    public void setCountCental(Integer countCental) {
        this.countCental = countCental;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }
}
