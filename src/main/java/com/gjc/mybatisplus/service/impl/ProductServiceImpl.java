package com.gjc.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.mybatisplus.mapper.ProductMapper;
import com.gjc.mybatisplus.pojo.Product;
import com.gjc.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
