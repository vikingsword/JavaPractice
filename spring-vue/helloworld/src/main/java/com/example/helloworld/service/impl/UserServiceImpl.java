package com.example.helloworld.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.helloworld.entity.User;
import com.example.helloworld.mapper.UserMapper;
import com.example.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vikingar
 * @time 2024/1/11 20:22
 * @description userService impl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserInfo() {
        return userMapper.getUserInfo();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Boolean addUser(User user) {
        int flag = userMapper.insert(user);
        return flag == 1;
    }

    @Override
    public Boolean updateUser(User user) {
        int flag = userMapper.updateById(user);
        return flag == 1;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        int flag = userMapper.deleteById(id);
        return flag == 1;
    }

}
