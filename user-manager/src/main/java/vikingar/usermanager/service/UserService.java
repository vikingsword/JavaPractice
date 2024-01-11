package vikingar.usermanager.service;

import com.github.pagehelper.PageInfo;
import vikingar.usermanager.entity.User;
import vikingar.usermanager.entity.query.UserQuery;

import java.util.List;

public interface UserService {

    // 查询所有用户
    List<User> listUser();

    // 根据用户名查询用户并分页表示
    PageInfo<User> listUserByName(UserQuery userQuery);

    // 根据 id 删除用户
    Boolean deleteUserById(Integer id);

    User selectUserById(Integer id);

    Boolean updateUser(User user);

    List<User> selectUserByName(String name);

    Boolean adduser(User user);
}
