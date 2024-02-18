package top.vikingar.controller.student;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vikingar.base.BaseApiController;
import top.vikingar.domain.User;
import top.vikingar.service.UserService;

/**
 * @author vikingar
 * @time 2024/2/18 11:26
 * @description
 */
@RestController
@RequestMapping("api/student/user")
public class UserController extends BaseApiController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("info")
    public void getInfo() {
        User byId = userService.getById(1);
        System.out.println(byId);
    }



}
