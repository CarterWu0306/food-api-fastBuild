package com.carter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.carter.mapper")
@SpringBootApplication
public class SpringbootFastBuildFoodManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFastBuildFoodManageApplication.class, args);
    }

}
