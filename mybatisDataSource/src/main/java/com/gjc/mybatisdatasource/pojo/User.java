package com.gjc.mybatisdatasource.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {

    @TableId
    private Integer uid;

    private String name;

    private Integer age;

    private String email;

    private Integer is_delete;

    private Integer sex;
}
