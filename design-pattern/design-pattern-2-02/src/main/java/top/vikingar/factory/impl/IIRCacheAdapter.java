package top.vikingar.factory.impl;

import top.vikingar.design.matter.IIR;
import top.vikingar.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author vikingar
 * @time 2024/6/20 18:14
 * @description
 */
public class IIRCacheAdapter implements ICacheAdapter {

    private IIR iir = new IIR();


    public String get(String key) {
        return iir.get(key);
    }


    public void set(String key, String value) {
        iir.set(key, value);
    }


    public void set(String key, String value, long time, TimeUnit timeUnit) {
        iir.setExpire(key, value, time, timeUnit);
    }


    public void del(String key) {
        iir.del(key);
    }
}
