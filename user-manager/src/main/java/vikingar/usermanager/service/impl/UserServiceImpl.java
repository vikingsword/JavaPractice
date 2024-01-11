package vikingar.usermanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vikingar.usermanager.entity.User;
import vikingar.usermanager.entity.query.UserQuery;
import vikingar.usermanager.mapper.UserMapper;
import vikingar.usermanager.service.UserService;

import java.util.List;

/**
 * @author vikingar
 * @time 2024/1/9 12:43
 * @description
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public PageInfo<User> listUserByName(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        List<User> users = userMapper.listUserByName(userQuery);
        return new PageInfo<User>(users);
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        int flag = userMapper.deleteUserById(id);
        return flag == 1;
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public List<User> selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public Boolean adduser(User user) {
        return userMapper.adduser(user) > 0;
    }
}
