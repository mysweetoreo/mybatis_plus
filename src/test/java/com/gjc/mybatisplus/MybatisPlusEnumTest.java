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
        user.setSex(EnumSex.MALE);
        user.setEmail("www.baidu.com");

        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void Timetest() {

            // TODO Auto-generated method stub
            String str1="2015-02-08";
            String str2="2015-01-08";
            int res=str1.compareTo(str2);
            if(res>0)
                System.out.println("str1>str2");
            else if(res==0)
                System.out.println("str1=str2");
            else
                System.out.println("str1<str2");

    }

}
