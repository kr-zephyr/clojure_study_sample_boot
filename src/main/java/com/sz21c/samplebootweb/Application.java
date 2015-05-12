package com.sz21c.samplebootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * <pre>
 * Spring Boot 실행 main class.
 * 
 * @SpringBootApplication은 Spring Boot 1.2부터 지원하는 Annotation으로
 * @Configuration, @ComponentScan, @EnableAutoConfiguration, @EnableWebMvc
 * 등의 Annotation을 포함한다.
 * 
 * 참고 : https://spring.io/guides/gs/serving-web-content/
 * </pre>
 *
 * @author 이승철 <scin21c@gmail.com>
 * @since 2015. 5. 12.
 *
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
