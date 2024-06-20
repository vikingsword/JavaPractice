package top.vikingar.store.impl;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vikingar.design.coupon.CouponResult;
import top.vikingar.design.coupon.CouponService;
import top.vikingar.store.ICommodity;

import java.util.Map;

/**
 * @author vikingar
 * @time 2024/6/20 13:43
 * @description
 */
public class CouponCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        CouponResult result = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, extMap);
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(result));
        if (!"0000".equals(result.getCode())) throw new RuntimeException(result.getInfo());
    }
}
