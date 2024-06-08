package com.example.geektrust.Model;

import com.example.geektrust.Enums.DiscountCouponType;
import com.example.geektrust.Service.MainService;
import com.example.geektrust.Utility.Constants;

import java.util.HashMap;

public class DiscountCoupon {
    private DiscountCouponType discountCouponType;
    private Double discountValue;
    private static HashMap<DiscountCouponType,DiscountCoupon> discountCoupons = new HashMap<>();

    public DiscountCoupon(DiscountCouponType discountCouponType, Double discountValue) {
        this.discountCouponType = discountCouponType;
        this.discountValue = discountValue;
    }

    public DiscountCouponType getDiscountCouponType() {
        return discountCouponType;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public DiscountCoupon(String discountName) {
        this.discountCouponType = DiscountCouponType.valueOf(discountName);
        discountCoupons.put(this.discountCouponType,this);
    }

    public static DiscountCoupon calculateDiscount() {
        Double discount = 0.0;
        if(OnlineProgram.getTotalCountOfPrograms() >= Constants.B4G1_SIZE_THRESHOLD){
           OnlineProgram onlineProgram = OnlineProgram.getMinProgram();
           discount += (MainService.getIsProMemberShipPresent() ? onlineProgram.getPrice() - onlineProgram.getProMembershipDiscount() : onlineProgram.getPrice());
           return new DiscountCoupon(DiscountCouponType.B4G1,discount);
        }
        if(discountCoupons.containsKey(DiscountCouponType.DEAL_G20)){
            if(Bill.getSubTotal() >= Constants.DEAL_G20_PRICE_THRESHOLD){
                discount += Bill.getSubTotal() * Constants.DEAL_G20_DISCOUNT_PERCENTAGE;
                return new DiscountCoupon(DiscountCouponType.DEAL_G20,discount);
            }
        }
        if(discountCoupons.containsKey(DiscountCouponType.DEAL_G5)){
            if(OnlineProgram.getTotalCountOfPrograms() >= Constants.DEAL_G5_SIZE_THRESHOLD) {
                discount += Bill.getSubTotal() * Constants.DEAL_G5_DISCOUNT_PERCENTAGE;
                return new DiscountCoupon(DiscountCouponType.DEAL_G5,discount);
            }
        }
        return new DiscountCoupon(DiscountCouponType.NONE,discount);
    }
}
