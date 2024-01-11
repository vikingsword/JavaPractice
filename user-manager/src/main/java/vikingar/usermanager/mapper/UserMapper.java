package vikingar.usermanager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vikingar.usermanager.entity.User;
import vikingar.usermanager.entity.query.UserQuery;

import java.util.List;


// 告诉springboot这是一个springboot的mapper类
@Mapper
// 将 catMapper 交给 spring 容器管理
@Repository
public interface UserMapper {

    // 查询所有用户
    List<User> listUser();

    // 根据用户名查询用户并分页表示
    List<User> listUserByName(UserQuery userQuery);

    // 根据 id 删除用户
    int deleteUserById(Integer id);

    // 根据id查询用户
    User selectUserById(Integer id);

    // 更新用户
    Integer updateUser(User user);

    // 根据 name 精确搜索
    List<User> selectUserByName(String name);

    // 新增用户
    Integer adduser(User user);

}
