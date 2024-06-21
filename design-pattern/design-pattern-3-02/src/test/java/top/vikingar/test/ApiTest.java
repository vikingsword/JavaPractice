package top.vikingar.test;

import org.junit.Test;
import top.vikingar.design.Builder;

/**
 * @author vikingar
 * @time 2024/6/21 10:33
 * @description
 */
public class ApiTest {

    @Test
    public void test_builder() {
        Builder builder = new Builder();

        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());

        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());

        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());

    }
}
