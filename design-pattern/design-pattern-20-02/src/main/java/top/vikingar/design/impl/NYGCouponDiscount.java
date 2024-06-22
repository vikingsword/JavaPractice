package top.vikingar.design.impl;

import top.vikingar.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author vikingar
 * @time 2024/6/22 16:14
 * @description
 */
public class NYGCouponDiscount implements ICouponDiscount<Double> {

    /**
     * n元购
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
