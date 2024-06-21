package top.vikingar.test;

import org.junit.Test;
import top.vikingar.design.Singleton_07;

/**
 * @author vikingar
 * @time 2024/6/21 13:20
 * @description
 */
public class ApiTest {

    /**
     * 这种写法在功能上与共有域⽅法相近，但是它更简洁，⽆偿地提供了串⾏化机制，绝对防⽌对此实例
     * 化，即使是在⾯对复杂的串⾏化或者反射攻击的时候。虽然这中⽅法还没有⼴泛采⽤，但是单元素的枚
     * 举类型已经成为实现Singleton的最佳⽅法。
     * 但也要知道此种⽅式在存在继承场景下是不可⽤的。
     */
    @Test
    public void test_singleton_07() {
        Singleton_07.INSTANCE.test();
    }
}
