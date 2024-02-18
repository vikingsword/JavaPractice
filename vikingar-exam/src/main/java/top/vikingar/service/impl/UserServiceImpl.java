package top.vikingar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.vikingar.domain.User;
import top.vikingar.mapper.UserMapper;
import top.vikingar.service.UserService;

/**
 * @author vikingar
 * @time 2024/2/18 11:54
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



}
