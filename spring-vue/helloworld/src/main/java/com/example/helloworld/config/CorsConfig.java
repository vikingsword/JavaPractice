package com.example.helloworld.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author vikingar
 * @time 2024/1/16 16:19
 * @description 跨域配置类 另外一种解决方案直接在controller上面加上 @CrossOrigin
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("*")
                .allowedOriginPatterns("*")
                .allowedMethods("POST", "GET", "PUT", "OPTION", "DELETE")
                .maxAge(168000)
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}
