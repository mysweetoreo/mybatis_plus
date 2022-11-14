package com.gjc.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.mybatisplus.mapper.UserMapper;
import com.gjc.mybatisplus.pojo.User;
import com.gjc.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
