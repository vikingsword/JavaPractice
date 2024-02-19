package top.vikingar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.vikingar.domain.User;

public interface UserService extends IService<User> {


    User getUserIdByName(String student);

    User getUserByName(String name);
}
