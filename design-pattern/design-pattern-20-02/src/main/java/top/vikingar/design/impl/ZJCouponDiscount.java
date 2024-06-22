package top.vikingar.design.impl;

import top.vikingar.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author vikingar
 * @time 2024/6/22 16:16
 * @description
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ONE) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}
