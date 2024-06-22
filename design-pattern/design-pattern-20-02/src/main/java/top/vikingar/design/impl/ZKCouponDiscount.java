package top.vikingar.design.impl;

import top.vikingar.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author vikingar
 * @time 2024/6/22 16:18
 * @description
 */
public class ZKCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 折扣计算
     * 1. 使用商品价格乘以折扣比例，为最后支付金额
     * 2. 保留两位小数
     * 3. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);
        if (discountAmount.compareTo(BigDecimal.ONE) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}
