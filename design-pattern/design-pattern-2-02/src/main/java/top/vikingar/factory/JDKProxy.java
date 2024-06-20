package top.vikingar.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author vikingar
 * @time 2024/6/20 18:40
 * @description
 */
public class JDKProxy {

    /**
     * 泛型方法 getProxy，接受一个接口类型的 Class 对象和一个 ICacheAdapter 实例作为参数
     * JDKProxy 类的 getProxy 方法用于创建一个指定接口的动态代理对象，并将方法调用转发给 ICacheAdapter 实例处理。
     * 这样可以在不修改原始接口实现的情况下，灵活地增加额外的行为，例如缓存、日志记录等。
     * <T>:
     *      1.这是一个类型参数声明。它表示 getProxy 方法是一个泛型方法，可以接受任何类型 T
     * T：
     *      1.这是方法的返回类型。由于方法是泛型方法，因此返回类型 T 与类型参数 T 保持一致。
     *      2.在方法执行过程中，T 将由调用方法时传递的具体类型确定。
     */
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        // 创建一个 JDKInvocationHandler 实例，将 ICacheAdapter 实例传入
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);

        // 获取当前线程的上下文类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        // 获取指定接口类型的所有接口（这里假设 interfaceClass 是一个接口类型）
        Class<?>[] classes = interfaceClass.getInterfaces();

        // 使用 Proxy.newProxyInstance 创建一个代理实例
        // 参数分别为类加载器、代理类实现的接口数组、调用处理器
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }

}
