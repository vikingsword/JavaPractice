package com.example.helloworld.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @author vikingar
 * @time 2024/1/11 12:21
 * @description user entity
 *
 */
@Data
@TableName("t_user")
public class User {

    // 新增 user 对象的时候会自动带上主键id，即使前端传入的user没有带id，在 userMapper.insert() 之后方便取最新的id值
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String birthday;

    // 描述用户所有订单
    @TableField(exist = false)
    private List<Order> orders;

}
