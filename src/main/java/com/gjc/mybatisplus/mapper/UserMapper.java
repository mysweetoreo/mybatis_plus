package com.gjc.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjc.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository /*标记为持久层*/
public interface UserMapper extends BaseMapper<User> {

    /**
     * @param id
     * @return
     */
    Map<String,Object> selectMapByID(Long id);

    /**
     * @param page
     * @param age
     * @return
     */
    Page<User> selectUserPage(@Param("page") Page<User> page,@Param("age") Integer age);
}
