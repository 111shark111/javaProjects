package com.example.geektrust.Service;

import com.example.geektrust.Model.Bill;
import com.example.geektrust.Model.DiscountCoupon;
import com.example.geektrust.Model.OnlineProgram;

public class MainService {

    private static Boolean isProMemberShipPresent = false;
    private static Double totalProDiscount = 0.0;

    public void mainService(String[] parts){
        String command = parts[0];
        switch (command){
            case "ADD_PROGRAMME" : {
                new OnlineProgram(parts[1],parts[2]);
                break;
            }
            case "APPLY_COUPON":{
                new DiscountCoupon(parts[1]);
                break;
            }
            case "ADD_PRO_MEMBERSHIP":{
                setIsProMemberShipPresent(true);
                setTotalProDiscount(OnlineProgram.getTotalProDiscount());
                break;
            }
            case "PRINT_BILL":{
                Bill.printBill();
                break;
            }
        }
    }

    public static Boolean getIsProMemberShipPresent() {
        return isProMemberShipPresent;
    }

    public static void setIsProMemberShipPresent(Boolean isProMemberShipPresent) {
        MainService.isProMemberShipPresent = isProMemberShipPresent;
    }

    public static Double getTotalProDiscount() {
        return totalProDiscount;
    }

    public static void setTotalProDiscount(Double totalProDiscount) {
        MainService.totalProDiscount = totalProDiscount;
    }
}