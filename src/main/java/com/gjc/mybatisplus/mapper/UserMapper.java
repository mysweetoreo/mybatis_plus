package com.gjc.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gjc.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository /*标记为持久层*/
public interface UserMapper extends BaseMapper<User> {

    Map<String,Object> selectMapByID(Long id);
}
