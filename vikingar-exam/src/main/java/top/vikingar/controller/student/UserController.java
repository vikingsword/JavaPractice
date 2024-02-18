package top.vikingar.controller.student;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.vikingar.base.BaseApiController;
import top.vikingar.base.RestResponse;
import top.vikingar.domain.User;
import top.vikingar.service.AuthenticationService;
import top.vikingar.service.UserService;
import top.vikingar.viewmodel.UserRegisterVM;

import javax.validation.Valid;

/**
 * @author vikingar
 * @time 2024/2/18 11:26
 * @description
 */
@RestController
@RequestMapping("api/student/user")
public class UserController extends BaseApiController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Autowired
    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }


    @GetMapping("test")
    public String testUser() {
        User user = userService.getUserIdByName("student");
        return String.valueOf(user.getId());
    }

    @PostMapping("register")
    public RestResponse register(@RequestBody @Valid UserRegisterVM userModel) {
        User userExist = userService.getUserByName(userModel);
        if (null != userExist) {
            return new RestResponse(2, "user exist");
        }
        User user = modelMapper.map(userModel, User.class);
        String encodePwd = authenticationService.pwdEncode(user.getPassword());

        return null;
    }


}
