package com.gjc.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gjc.mybatisplus.mapper.UserMapper;
import com.gjc.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //查询名字包含a  年龄在20之40 email不为空的
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a")
                .between("age",20,40)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //先按照年龄降序排列 再按照升序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("age")
                    .orderByAsc("uid");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    @Test
    public void test03(){
        //删除email为空的数据
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println("result:"+delete);

    }

    @Test
    public void test04(){
        //年龄大于10 小于 30并且 名字中有g的 或者eamil为空的 进行修改
        //UPDATE t_user SET name=?, email=? WHERE is_delete=0 AND (age > ? AND age < ? AND name LIKE ? OR email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",10)
                .lt("age",30)
                .like("name","g")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("gjc天下无敌");
        user.setEmail("www.cn.bing.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:"+result);
    }

    //条件的优先级
    @Test
    public void test05(){
        //将用户名含有g并且 （年龄大于60 小于80 或者邮箱为空 ）的用户进行修改
        //lambda 优先执行
        // UPDATE t_user SET age=? WHERE is_delete=0 AND (name LIKE ? AND (age > ? AND age < ? OR email IS NULL))
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.like("name","g")
                .and(i->i.gt("age",60).lt("age",80).or().isNull("email"));

        User user = new User();
        user.setAge(71);

        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:"+result);
    }

    //组装select 查询语句
    @Test
    public void test06(){
        //SELECT name,age,email FROM t_user WHERE is_delete=0
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age","email");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    //select 子查询
    @Test
    public void test07(){
        //查询uid 大于10
        //SELECT uid AS id,name,age,email,is_delete AS idDelete FROM t_user WHERE is_delete=0 AND (uid IN (select uid from t_user where uid > 10))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid","select uid from t_user where uid > 10");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    //使用UpdateWrapper
    @Test
    public void test08(){
        //UPDATE t_user SET name=?,age=? WHERE is_delete=0 AND (name LIKE ? AND (age > ? AND age < ? AND email IS NULL))
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("name","g")
                .and(i->i.gt("age",20).lt("age",100).isNull("email"));

        userUpdateWrapper.set("name","gjcUpdateWrapper").set("age","66");
        int result = userMapper.update(null, userUpdateWrapper);
        System.out.println(result);
    }

    //模拟开发中的组装
    @Test
    public void test09(){
        String name ="g";
        Integer ageBegin= 30;
        Integer ageEnd = 35;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isBlank(name)){
            queryWrapper.like("name","g");
        }
        if (ageBegin!=null){
            queryWrapper.ge("age",ageBegin);
        }
        if (ageEnd!=null){
            queryWrapper.le("age",ageEnd);
        }
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

}
