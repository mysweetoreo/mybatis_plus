package com.gjc.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjc.mybatisplus.mapper.UserMapper;
import com.gjc.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusPageTest {

    @Autowired
    private UserMapper userMapper;

    //Mybatis-plus 分页插件
    @Test
    public void test01(){
        //SELECT uid AS id,name,age,email,is_delete AS idDelete FROM t_user WHERE is_delete=0 LIMIT ?
        Page<User> page = new Page(1,3);
        userMapper.selectPage(page, null);
        System.out.println(page);

        //分页相关数据获取
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getSize());
    }

}
