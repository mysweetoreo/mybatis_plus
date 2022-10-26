package com.gjc.mybatisplus;

import com.gjc.mybatisplus.mapper.UserMapper;
import com.gjc.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsertUser(){
        //实现新增用户
        User user = new User();
        user.setName("关羽");
        user.setAge(40);
        user.setEmail("www.shuguo@.com");
        int result = userMapper.insert(user);
        System.out.println("result"+result);
        System.out.println(user.getId());
    }

    @Test
    public void testDelete(){
        //deleteById
        //int result = userMapper.deleteById(0);

        //deleteByMap
        //DELETE FROM user WHERE name = ? AND age = ?
        /*Map<String,Object> map = new HashMap();
        map.put("name","Billie");
        map.put("age",23);
        int result = userMapper.deleteByMap(map);*/

        //deleteBatchIds
        //DELETE FROM user WHERE id IN ( ? , ? )
        List<Long> list = Arrays.asList(5L,6L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result:"+result);
    }

    @Test
    public void testUpdate(){
        //修改
        //UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId(4L);
        user.setName("吕布");
        user.setEmail("www.baidu.com");
        int result = userMapper.updateById(user);
        System.out.println("result"+result);
    }

    @Test
    public void testSelect(){
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        /*List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);*/

        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        /*Map<String,Object> map = new HashMap();
        map.put("name","Jack");
        map.put("age",20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);*/

        //SELECT id,name,age,email FROM user
        /*List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);*/


        //自定义接口方法
        //select id,name,age,email from user where id = ?
        Map<String, Object> map = userMapper.selectMapByID(1L);
        System.out.println(map);


    }
}
