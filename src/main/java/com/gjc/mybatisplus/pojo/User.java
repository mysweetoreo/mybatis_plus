package com.gjc.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.gjc.mybatisplus.enums.EnumSex;
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
    //@TableId(value = "uid",type = IdType.AUTO) type 设置主键生成策略
    //      IdType.AUTO 前提需要表主键设置自增
    //      IdType.ASSIGN_ID(默认) 雪花自增
    @TableId("uid")
    private Long id;

    @TableField("name")
    private String name;

    private Integer age;

    private String email;

    private EnumSex sex;

    @TableLogic //逻辑删除 删除时 把表中is_delete 字段状态为0的改成1 全部查询时 状态为1的不会被查询出来
    @TableField("is_delete")
    private Integer idDelete;
}
