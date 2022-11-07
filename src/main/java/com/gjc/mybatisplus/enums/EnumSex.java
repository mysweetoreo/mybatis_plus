package com.gjc.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum EnumSex {

    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue  //将注解标识的值保存到数据库中
    private Integer sex;

    private String sexName;

    EnumSex(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
