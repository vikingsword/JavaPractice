package top.vikingar.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vikingar.design.Context;
import top.vikingar.design.impl.MJCouponDiscount;
import top.vikingar.design.impl.NYGCouponDiscount;
import top.vikingar.design.impl.ZJCouponDiscount;
import top.vikingar.design.impl.ZKCouponDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vikingar
 * @time 2024/6/22 16:24
 * @description
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_mj() {
        Context<Map<String, String>> context = new Context<>(new MJCouponDiscount());
        Map<String, String> map = new HashMap<>();
        map.put("x", "100");
        map.put("n", "10");
        BigDecimal discountAmount = context.discountAmount(map, new BigDecimal("120"));
        logger.info("测试结果：满减优惠后金额 {}", discountAmount);
    }


    @Test
    public void test_nyg() {
        Context<Double> context = new Context<>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(2D, new BigDecimal("120"));
        logger.info("测试结果：满减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_zj() {
        Context<Double> context = new Context<>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(120D, new BigDecimal("120"));
        logger.info("测试结果：满减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_zk() {
        Context<Double> context = new Context<>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.8, new BigDecimal(100));
        logger.info("测试结果：满减优惠后金额 {}", discountAmount);
    }


}
