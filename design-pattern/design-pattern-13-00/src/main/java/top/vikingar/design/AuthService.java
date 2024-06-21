package top.vikingar.design;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vikingar
 * @time 2024/6/21 14:55
 * @description 模拟审核服务
 * 1. auth          审核流程
 * 2. queryAuthInfo 查询审核信息(时间)
 */
public class AuthService {

    private static Map<String, Date> authMap = new ConcurrentHashMap<>();

    public static Date queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }

    public static void auth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), new Date());
    }
}
