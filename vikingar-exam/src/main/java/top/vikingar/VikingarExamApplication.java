package top.vikingar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.vikingar.mapper")
public class VikingarExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(VikingarExamApplication.class, args);
    }

}
