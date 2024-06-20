package top.vikingar.design;

import java.util.concurrent.TimeUnit;

/**
 * @author vikingar
 * @time 2024/6/20 15:40
 * @description
 */
public interface CacheService {

    String get(final String key, int redisType);

    void set(String key, String value, int redisType);

    void set(String key, String value, long time, TimeUnit timeUnit, int redisType);

    void del(String key, int redisType);

}
