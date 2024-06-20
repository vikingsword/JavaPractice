package top.vikingar.factory;

import top.vikingar.utils.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author vikingar
 * @time 2024/6/20 18:09
 * @description
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter iCacheAdapter) {
        this.cacheAdapter = iCacheAdapter;
    }

    /**
     * 这段代码定义了一个实现 InvocationHandler 接口的类 JDKInvocationHandler，
     * 用于处理动态代理对象的方法调用。它的主要作用是拦截对代理对象的方法调用，并将调用转发给 ICacheAdapter 实例的方法。
     * @return 代理对象调用的目标方法的返回值
     * @throws Throwable exception
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }
}
