package top.vikingar;

import top.vikingar.store.ICommodity;
import top.vikingar.store.impl.CardCommodityService;
import top.vikingar.store.impl.CouponCommodityService;
import top.vikingar.store.impl.GoodsCommodityService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vikingar
 * @time 2024/6/20 13:52
 * @description
 */
public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        ICommodity commodityService;
        switch (commodityType) {
            case 1:
                commodityService = new CardCommodityService();
                break;
            case 2:
                commodityService = new CouponCommodityService();
                break;
            case 3:
                commodityService = new GoodsCommodityService();
                break;
            default:
                commodityService = null;
        }
        return commodityService;
    }

    public ICommodity getCommodityService2(Integer commodityType) {
        Map<Integer, ICommodity> map = new HashMap<>();
        map.put(1, new CardCommodityService());
        map.put(2, new CouponCommodityService());
        map.put(3, new GoodsCommodityService());
        return map.get(commodityType);
    }

    public ICommodity getCommodityService3(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CardCommodityService();
        if (2 == commodityType) return new CouponCommodityService();
        if (3 == commodityType) return new GoodsCommodityService();
        throw new RuntimeException("不存在该类型的商品");
    }
}
