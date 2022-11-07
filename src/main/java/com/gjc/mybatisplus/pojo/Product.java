package com.gjc.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Product {

    private Long id;

    private String name;

    private Integer price;

    @Version //标识乐观锁
    private Integer version;
}
