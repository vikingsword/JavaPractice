package top.vikingar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vikingar.domain.User;
import top.vikingar.mapper.UserMapper;
import top.vikingar.service.UserService;
import top.vikingar.viewmodel.UserRegisterVM;

/**
 * @author vikingar
 * @time 2024/2/18 11:54
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public User getUserIdByName(String student) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, "student");
        return getOne(wrapper);
    }

    @Override
    public User getUserByName(UserRegisterVM userModel) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, userModel.getUserName());
        return getOne(wrapper);
    }


}
