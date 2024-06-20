package top.vikingar.store.impl;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vikingar.design.card.IQiYiCardService;
import top.vikingar.store.ICommodity;

import java.util.Map;

/**
 * @author vikingar
 * @time 2024/6/20 13:39
 * @description
 */
public class CardCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        String bindPhoneNumber = queryBindPhoneNum(uId);
        iQiYiCardService.grantToken(bindPhoneNumber, bizId);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryBindPhoneNum(String uId) {
        return "1234";
    }
}
