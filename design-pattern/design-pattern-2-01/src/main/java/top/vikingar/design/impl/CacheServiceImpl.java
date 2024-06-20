package top.vikingar.design.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vikingar.design.CacheService;
import top.vikingar.design.RedisUtils;
import top.vikingar.design.matter.EGM;
import top.vikingar.design.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * @author vikingar
 * @time 2024/6/20 15:43
 * @description
 */
public class CacheServiceImpl implements CacheService {

    private Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    // 模拟注入
    private EGM egm = new EGM();

    private IIR iir = new IIR();

    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key, int redisType) {
        if (1 == redisType) {
            // egm
            return egm.gain(key);
        } else if (2 == redisType) {
            // iir
            return iir.get(key);
        }
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value, int redisType) {
        if (1 == redisType) {
            egm.set(key, value);
            return;
        } else if (2 == redisType) {
            iir.set(key, value);
            return;
        }
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long time, TimeUnit timeUnit, int redisType) {
        if (1 == redisType) {
            egm.setEx(key, value, time, timeUnit);
            return;
        } else if (2 == redisType) {
            iir.setExpire(key, value, time, timeUnit);
            return;
        }
        redisUtils.set(key,value, time, timeUnit);
    }

    @Override
    public void del(String key, int redisType) {
        if (1 == redisType) {
            egm.delete(key);
            return;
        } else if (2 == redisType) {
            iir.del(key);
            return;
        }
        redisUtils.del(key);
    }



}
