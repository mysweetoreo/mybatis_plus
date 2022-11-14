package com.gjc.mybatisdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.mybatisdatasource.mapper.UserMapper;
import com.gjc.mybatisdatasource.pojo.User;
import com.gjc.mybatisdatasource.service.UserService;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
