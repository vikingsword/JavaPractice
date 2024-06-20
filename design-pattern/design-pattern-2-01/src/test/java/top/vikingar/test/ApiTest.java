package top.vikingar.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vikingar.design.impl.CacheServiceImpl;

/**
 * @author vikingar
 * @time 2024/6/20 15:51
 * @description
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_CacheService() {
        CacheServiceImpl cacheService = new CacheServiceImpl();
        cacheService.set("user_001", "vikingar", 1);
        String value = cacheService.get("user_001", 1);
        System.out.println("测试结果： " + value);

        cacheService.set("user_001", "vikingar2", 2);
        String value2 = cacheService.get("user_001", 2);
        System.out.println("测试结果： " + value);

        cacheService.set("user_001", "vikingar3", 3);
        String value3 = cacheService.get("user_001", 3);
        System.out.println("测试结果： " + value);
    }
}
