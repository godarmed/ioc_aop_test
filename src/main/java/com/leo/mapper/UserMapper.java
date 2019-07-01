package com.leo.mapper;


import com.leo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //@Select("select * from user")
    List<User> selectUserAll();
}
