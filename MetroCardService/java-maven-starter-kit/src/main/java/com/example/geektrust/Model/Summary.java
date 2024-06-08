package com.example.geektrust.Model;


import com.example.geektrust.Utility.CommonUtils;
import com.example.geektrust.Utility.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Summary {
    private String destination;
    private Integer totalCollection;
    private Integer discountGiven;
    private Integer numberOfKids;
    private Integer numberOfAdults;
    private Integer numberOfSeniorCitizens;

    public Summary(String destination) {
        this.destination = destination;
        this.totalCollection = 0;
        this.discountGiven = 0;
        this.numberOfAdults=0;
        this.numberOfKids=0;
        this.numberOfSeniorCitizens = 0;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getTotalCollection() {
        return totalCollection;
    }

    public void setTotalCollection(Integer totalCollection) {
//        System.out.println(this.destination + "----" + totalCollection);
        this.totalCollection = totalCollection;
    }

    public Integer getDiscountGiven() {
        return discountGiven;
    }

    public void setDiscountGiven(Integer discountGiven) {
        this.discountGiven = discountGiven;
    }

    public Integer getNumberOfKids() {
        return numberOfKids;
    }

    public void setNumberOfKids(Integer numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public Integer getNumberOfSeniorCitizens() {
        return numberOfSeniorCitizens;
    }

    public void setNumberOfSeniorCitizens(Integer numberOfSeniorCitizens) {
        this.numberOfSeniorCitizens = numberOfSeniorCitizens;
    }

    public void printRequiredSummary(){
        System.out.println(Constants.TOTAL_COLLECTION + " " + this.destination + " " + this.totalCollection + " "+ this.discountGiven);
        System.out.println(Constants.PASSENGER_TYPE_SUMMARY);
        List<HashMap.Entry<Integer,String>> requiredList = CommonUtils.getRequiredOutputList(this.numberOfAdults,this.numberOfKids,this.numberOfSeniorCitizens);
        requiredList.forEach(element->{
            if(element.getKey() != 0) {
                System.out.println(element.getValue() + " " + element.getKey());
            }
        });
    }
}
