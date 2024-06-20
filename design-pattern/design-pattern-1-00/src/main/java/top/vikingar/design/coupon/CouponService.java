package top.vikingar.design.coupon;

/**
 * @author vikingar
 * @time 2024/6/20 11:34
 * @description
 */
public class CouponService {

    public CouponResult sendCoupon(String uid, String couponNum, String uuid) {
        System.out.println("模拟发放优惠券一张： " + "uid = " + uid + "; couponNum = " + couponNum + "; uuid = " + uid);
        return new CouponResult("0000", "success");
    }
}
