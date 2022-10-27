package com.gjc.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode*/
@Data
//方式一 配置数据数据库中表的别名
@TableName("t_user")
public class User {

    //设置为主键 当主键名字不为id时
    //当实体类和表中的字段不相同时 可以通过value属性进行设置 只有value是可一省略  @TableId("uid")
    @TableId(value = "uid")
    private Long id;

    private String name;

    private Integer age;

    private String email;
}
