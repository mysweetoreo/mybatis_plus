package com.gjc.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.mybatisx.pojo.User;
import com.gjc.mybatisx.service.UserService;
import com.gjc.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-11-14 16:23:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




