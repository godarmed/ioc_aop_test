package com.leo.service;

import com.leo.entity.User;
import com.leo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserAll() {
        return userMapper.selectUserAll();
    }
}
