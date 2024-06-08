package com.example.geektrust.Model;

import com.example.geektrust.Enums.ProgramType;
import com.example.geektrust.Service.MainService;
import com.example.geektrust.Utility.Constants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OnlineProgram {
    private ProgramType type;
    private Integer price;
    private Integer proMembershipDiscount;
    private Integer quantity;
    private static final List<OnlineProgram> allPrograms = new ArrayList<>();

    public static Integer getTotalCountOfPrograms() {
        return totalCountOfPrograms;
    }

    private static Integer totalCountOfPrograms = 0;

    public OnlineProgram(String programTypeString,String quantityString) {
        this.quantity = Integer.parseInt(quantityString);
        this.type = ProgramType.valueOf(programTypeString);
        this.price = type.getPrice();
        this.proMembershipDiscount = type.getProMembershipDiscount();
        allPrograms.add(this);
        totalCountOfPrograms += quantity;
    }
    public static Double getGeneralFare(){
        Boolean isProMembershipApplied = MainService.getIsProMemberShipPresent();
        Double fare = (isProMembershipApplied) ? Constants.PRO_MEMBERSHIP_FEES : 0.0;
        fare += getTotalPrice();
        fare -= (isProMembershipApplied) ? getTotalProDiscount() : 0;
        return fare;
    }

    private static Double getTotalPrice() {
        Double totalPrice = 0.0;
        for(OnlineProgram program : allPrograms){
            Integer programPrice = program.price;
            totalPrice += program.quantity * programPrice;
        }
        return totalPrice;
    }


    public static OnlineProgram getMinProgram() {
        allPrograms.sort(Comparator.comparing(element -> element.price));
        return allPrograms.get(0);
    }

    public static Double getTotalProDiscount() {
        Double totalProDiscount = 0.0;
        for(OnlineProgram program : allPrograms){
            Integer programPrice = program.proMembershipDiscount;
            totalProDiscount += program.quantity * programPrice;
        }
        return totalProDiscount;
    }


    public Integer getPrice() {
        return price;
    }

    public Integer getProMembershipDiscount() {
        return proMembershipDiscount;
    }

}
