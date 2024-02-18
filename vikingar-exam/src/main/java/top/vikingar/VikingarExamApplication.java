package top.vikingar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import top.vikingar.config.property.SystemConfig;

@SpringBootApplication
@MapperScan("top.vikingar.mapper")
@EnableConfigurationProperties(SystemConfig.class)
public class VikingarExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(VikingarExamApplication.class, args);
    }

}
