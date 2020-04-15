package com.wc.project.fruitshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@MapperScan("com.wc.project.fruitshop.mapper")
public class FruitshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruitshopApplication.class, args);
    }

}
