package com.gjc.mybatisplus;

import com.gjc.mybatisplus.enums.EnumSex;
import com.gjc.mybatisplus.mapper.UserMapper;
import com.gjc.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        User user = new User();
        user.setName("enumName");
        user.setAge(99);
        //user.setSex(EnumSex.MALE);
        user.setIdDelete(0);

        int result = userMapper.insert(user);
        System.out.println(result);
    }


}
