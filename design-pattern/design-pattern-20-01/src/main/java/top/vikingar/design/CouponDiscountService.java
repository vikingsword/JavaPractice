package top.vikingar.design;

/**
 * @author vikingar
 * @time 2024/6/22 15:48
 * @description 优惠券折扣计算接口
 * 优惠券类型；
 * 1. 直减券
 * 2. 满减券
 * 3. 折扣券
 * 4. n元购
 */
public class CouponDiscountService {

    public double discountAmount(int type, double typeContent, double skuPrice, double typeExt) {
        if (1 == type) {
            return skuPrice - typeContent;
        }
        if (2 == type) {
            if (skuPrice < typeExt) return skuPrice;
            else return skuPrice - typeExt;
        }
        if (3 == type) {
            return skuPrice * typeContent;
        }
        if (4 == type) {
            return typeContent;
        }
        return 0L;
    }
}
