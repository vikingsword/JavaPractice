package com.example.helloworld.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloworld.entity.User;
import com.example.helloworld.mapper.UserMapper;
import com.example.helloworld.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vikingar
 * @time 2024/1/11 17:25
 * @description user controller
 */
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("获取用户信息")
    @GetMapping("user/info")
    public List<User> userInfo() {
        List<User> userInfo = userService.getUserInfo();
        System.out.println(userInfo);
        return userInfo;
    }

    /**
     * restful style : get user by id
     * @param id 或者取 {id} 形式的参数要加 @PathVariable 注解
     * @return str
     */
    @ApiOperation("根据id获取用户")
    @GetMapping("user/{id}")
    public User getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        System.out.println(user);
        return user;
    }

    /**
     * save 和 update 的请求方法不一样，不会导致冲突
     * @param user
     * @return signal
     */
    @ApiOperation("添加用户")
    @PostMapping("user")
    public Boolean save(User user) {
        return userService.addUser(user);
    }

    /**
     * update user
     * @param user
     * @return mark
     */
    @ApiOperation("修改用户")
    @PutMapping("user")
    public Boolean update(User user) {
        return userService.updateUser(user);
    }

    /**
     * delete user
     * @param id
     * @return str
     */
    @ApiOperation("删除用户")
    @DeleteMapping("user/{id}")
    public Boolean deleteUserById(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    /**
     * get user with their order
     * @return userList
     */
    @ApiOperation("获取用户和订单信息")
    @GetMapping("all")
    public List<User> getAllUserAndOrder() {
        return userService.getUserAndOrder();
    }


    @ApiOperation("通过用户名获取用户")
    @GetMapping("user/name")
    public List<User> getUserByName(String name) {
        return userService.getUserByName(name);
    }


    @ApiOperation("分页查询用户")
    @GetMapping("findAll")
    public IPage findAll() {
        Page<User> page = new Page<>(0, 2);
        return userMapper.selectPage(page, null);
    }











}
