package com.example.geektrust.Model;

import com.example.geektrust.Service.MainService;
import com.example.geektrust.Utility.Constants;
import com.example.geektrust.Utility.DecimalFormatter;

import java.util.List;

public class Bill {
    private List<OnlineProgram> onlinePrograms;
    private List<DiscountCoupon> discountCoupons;

    public static Double getSubTotal() {
        return subTotal;
    }

    private static Double subTotal;



    public static Double printBill() {
        Double fare = OnlineProgram.getGeneralFare();
        subTotal = fare;
        DiscountCoupon discountCoupon = DiscountCoupon.calculateDiscount();
        fare -= discountCoupon.getDiscountValue();
        Boolean isEnrollmentFeeApplicable = fare < Constants.ENROLLMENT_AMOUNT_THRESHOLD;
        if(isEnrollmentFeeApplicable){
            fare += Constants.ENROLLMENT_FESS;
        }
        System.out.println(Constants.SUB_TOTAL + " " + DecimalFormatter.format(subTotal));
        System.out.println(Constants.COUPON_DISCOUNT + " " + discountCoupon.getDiscountCouponType().toString() + " " + DecimalFormatter.format(discountCoupon.getDiscountValue()));
        System.out.println(Constants.TOTAL_PRO_DISCOUNT +" "+ (MainService.getIsProMemberShipPresent() ? DecimalFormatter.format(OnlineProgram.getTotalProDiscount()) : "0.00"));
        System.out.println(Constants.PRO_MEMBERSHIP_FEE +" "+ (MainService.getIsProMemberShipPresent() ? DecimalFormatter.format(Constants.PRO_MEMBERSHIP_FEES) : "0.00"));
        System.out.println(Constants.ENROLLMENT_FEE +" "+ (isEnrollmentFeeApplicable? DecimalFormatter.format(Constants.ENROLLMENT_FESS) : "0.00"));
        System.out.println(Constants.TOTAL + " " + DecimalFormatter.format(fare));
        return fare;
    }
}
