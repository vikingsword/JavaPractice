package top.vikingar.factory;

import java.util.concurrent.TimeUnit;

/**
 * @author vikingar
 * @time 2024/6/20 18:10
 * @description
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long time, TimeUnit timeUnit);

    void del(String key);

}
