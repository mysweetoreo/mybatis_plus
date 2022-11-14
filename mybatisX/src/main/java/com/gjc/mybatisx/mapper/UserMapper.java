package com.gjc.mybatisx.mapper;
import java.util.List;
import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import org.apache.ibatis.annotations.Param;

import com.gjc.mybatisx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-11-14 16:23:06
* @Entity com.gjc.mybatisx.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    int delByNameAndName(@Param("name") String name, @Param("oldName") String oldName);

    int updateAgeAndNameByUid(@Param("age") Integer age, @Param("name") String name, @Param("uid") Long uid);

    List<User> selectAllBySexBetween(@Param("beginSex") Integer beginSex, @Param("endSex") Integer endSex);

    List<User> selectAllByUidOrderByUidDesc(@Param("uid") Long uid);


}




