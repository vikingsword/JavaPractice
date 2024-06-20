package top.vikingar.store.impl;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vikingar.design.goods.DeliverReq;
import top.vikingar.design.goods.GoodsService;
import top.vikingar.store.ICommodity;

import java.util.Map;
import java.util.UUID;

/**
 * @author vikingar
 * @time 2024/6/20 13:47
 * @description
 */
public class GoodsCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhone(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        Boolean isSuccess = goodsService.deliverGoods(deliverReq);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", isSuccess);

        if (!isSuccess) throw new RuntimeException("实体商品发放失败");
    }

    private String queryUserPhone(String uId) {
        return "1234";
    }

    private String queryUserName(String uId) {
        return "vikingar";
    }
}
