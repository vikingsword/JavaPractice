package com.example.helloworld.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.helloworld.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> getUserInfo();

    User getUserById(Integer id);

    Boolean addUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(Integer id);

    List<User> getUserAndOrder();

    List<User> getUserByName(String name);
}
