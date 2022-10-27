package com.gjc.mybatisplus;

import com.gjc.mybatisplus.pojo.User;
import com.gjc.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getAllCount(){
        long count = userService.count();
        System.out.println("总数量:"+count);
    }

    @Test
    public void testInsertMore(){
        //批量添加 单个添加循环
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("gjc"+i);
            user.setAge(i*10);
            user.setEmail("www.gjc"+i+"loveHome.com");
            list.add(user);
        }
        boolean flag = userService.saveBatch(list);
        System.out.println(flag);
    }
}
