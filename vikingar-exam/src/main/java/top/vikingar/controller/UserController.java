package top.vikingar.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vikingar.base.BaseApiController;
import top.vikingar.base.RestResponse;
import top.vikingar.viewmodel.student.user.UserResponseVM;

/**
 * @author vikingar
 * @time 2024/2/16 21:28
 * @description
 */
@RestController
@RequestMapping("api/student/user")
public class UserController extends BaseApiController {


    @PostMapping("current")
    public RestResponse<UserResponseVM> current() {

        return null;
    }

}
