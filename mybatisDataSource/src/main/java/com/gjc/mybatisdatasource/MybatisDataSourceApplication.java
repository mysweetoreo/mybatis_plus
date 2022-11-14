package com.gjc.mybatisdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gjc.mybatisdatasource.mapper")
public class MybatisDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDataSourceApplication.class, args);
    }

}
