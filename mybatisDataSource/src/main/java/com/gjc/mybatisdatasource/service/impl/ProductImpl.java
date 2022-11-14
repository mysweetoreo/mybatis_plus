package com.gjc.mybatisdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.mybatisdatasource.mapper.ProductMapper;
import com.gjc.mybatisdatasource.pojo.Product;
import com.gjc.mybatisdatasource.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@DS("slave_1")
public class ProductImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
