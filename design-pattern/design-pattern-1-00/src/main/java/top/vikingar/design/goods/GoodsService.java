package top.vikingar.design.goods;

import com.alibaba.fastjson.JSON;

/**
 * @author vikingar
 * @time 2024/6/20 11:39
 * @description
 */
public class GoodsService {

    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发送实物商品, " + JSON.toJSONString(req));
        return true;
    }

}
