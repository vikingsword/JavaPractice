package top.vikingar.test;

import org.junit.Test;
import top.vikingar.CacheService;
import top.vikingar.factory.JDKProxy;
import top.vikingar.factory.impl.EGMCacheAdapter;
import top.vikingar.factory.impl.IIRCacheAdapter;
import top.vikingar.impl.CacheServiceImpl;

/**
 * @author vikingar
 * @time 2024/6/20 18:59
 * @description
 */
public class ApiTest {

    @Test
    public void test_CacheService() throws Exception{
        CacheService proxy_egm = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_egm.set("user_001", "vikingar");
        String value = proxy_egm.get("user_001");
        System.out.println("测试结果： " + value);

        CacheService proxy_iir = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_iir.set("user_001", "niemandea");
        String value2 = proxy_iir.get("user_001");
        System.out.println("测试结果： " + value2);
    }

}
