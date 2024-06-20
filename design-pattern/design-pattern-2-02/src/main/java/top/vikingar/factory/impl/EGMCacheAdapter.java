package top.vikingar.factory.impl;

import top.vikingar.design.matter.EGM;
import top.vikingar.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author vikingar
 * @time 2024/6/20 18:12
 * @description
 */
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    public String get(String key) {
        return egm.gain(key);
    }


    public void set(String key, String value) {
        egm.set(key, value);
    }


    public void set(String key, String value, long time, TimeUnit timeUnit) {
        egm.setEx(key, value, time, timeUnit);
    }


    public void del(String key) {
        egm.delete(key);
    }
}
