package top.vikingar.design;

import java.math.BigDecimal;

/**
 * @author vikingar
 * @time 2024/6/22 16:07
 * @description 优惠券折扣计算接口
 *
 * 优惠券类型；
 * 1. 直减券
 * 2. 满减券
 * 3. 折扣券
 * 4. n元购
 */
public interface ICouponDiscount <T> {

    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);

}
