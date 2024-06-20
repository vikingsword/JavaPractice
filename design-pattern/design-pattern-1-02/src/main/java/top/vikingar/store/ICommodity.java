package top.vikingar.store;

import java.util.Map;

/**
 * @author vikingar
 * @time 2024/6/20 13:37
 * @description
 */
public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap);

}
