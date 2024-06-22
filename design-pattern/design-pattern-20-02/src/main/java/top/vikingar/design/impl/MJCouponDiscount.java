package top.vikingar.design.impl;

import top.vikingar.design.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author vikingar
 * @time 2024/6/22 16:09
 * @description 满减
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {

    /**
     * 满减计算
     * 1. 判断满足x元后-n元，否则不减
     * 2. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String n = couponInfo.get("n");
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(n));
        if (discountAmount.compareTo(BigDecimal.ONE) < 1) return BigDecimal.ONE;
        return discountAmount;
    }



}
