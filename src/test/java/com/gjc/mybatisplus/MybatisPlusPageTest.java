package com.gjc.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjc.mybatisplus.mapper.ProductMapper;
import com.gjc.mybatisplus.mapper.UserMapper;
import com.gjc.mybatisplus.pojo.Product;
import com.gjc.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusPageTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

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

    //自定义分页查询
    @Test
    public void test02(){
        //select uid,name,age,email from t_user where age > ? LIMIT ?
        Page page = new Page(1,3);
        userMapper.selectUserPage(page,20);

        //分页相关数据获取
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getSize());

    }

    //模拟修改冲突
    @Test
    public void test03(){

        //小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的商品价格:"+productLi.getPrice());

        //小王查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的商品价格:"+productWang.getPrice());

        //小李商品价格+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);

        //小李王商品价格-30
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);

        if(result == 0){
            //修改失败重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }

        //老板查询上坪价格
        Product productLaoBan = productMapper.selectById(1);
        System.out.println("老板查询的商品价格:"+productLaoBan.getPrice());

    }

}
