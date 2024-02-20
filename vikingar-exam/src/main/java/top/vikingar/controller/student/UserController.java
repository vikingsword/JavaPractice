package top.vikingar.controller.student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import top.vikingar.base.BaseApiController;
import top.vikingar.base.RestResponse;
import top.vikingar.domain.RoleEnum;
import top.vikingar.domain.User;
import top.vikingar.domain.UserEventLog;
import top.vikingar.domain.UserStatusEnum;
import top.vikingar.event.UserEvent;
import top.vikingar.service.AuthenticationService;
import top.vikingar.service.UserService;
import top.vikingar.viewmodel.user.UserRegisterVM;
import top.vikingar.viewmodel.user.UserResponseVM;
import top.vikingar.viewmodel.user.UserUpdateVM;

import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;

/**
 * @author vikingar
 * @time 2024/2/18 11:26
 * @description
 */
@RestController
@RequestMapping("api/student/user")
@Api(tags = "用户", description = "用户接口")
public class UserController extends BaseApiController {

    private final UserService userService;
    private final UserEventLogService userEventLogService;
    private final MessageService messageService;
    private final AuthenticationService authenticationService;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public UserController(UserService userService, AuthenticationService authenticationService, ApplicationEventPublisher eventPublisher, ) {
        this.userService = userService;
//        this.userEventLogService = userEventLogService;
//        this.messageService = messageService;
        this.authenticationService = authenticationService;
        this.eventPublisher = eventPublisher;
    }


    @GetMapping("test")
    @ApiOperation(value = "测试接口")
    public String testUser() {
        User user = userService.getUserIdByName("student");
        return String.valueOf(user.getId());
    }

    @PostMapping("register")
    @ApiOperation(value = "用户注册")
    public RestResponse register(@RequestBody @Valid UserRegisterVM userModel) {
        User userExist = userService.getUserByName(userModel.getUserName());
        if (null != userExist) {
            return new RestResponse(2, "user exist");
        }
        User user = modelMapper.map(userModel, User.class);
        String encodePwd = authenticationService.pwdEncode(user.getPassword());
        user.setPassword(encodePwd);
        user.setUserUuid(UUID.randomUUID().toString());
        user.setRole(RoleEnum.STUDENT.getCode());
        user.setStatus(UserStatusEnum.Enable.getCode());
        user.setLastActiveTime(new Date());
        user.setCreateTime(new Date());
        user.setDeleted(false);
        userService.save(user);
        UserEventLog userEventLog = new UserEventLog(user.getId(), user.getUserName(), user.getRealName(), new Date());
        userEventLog.setContent("欢迎 " + user.getUserName() + "注册考试系统");
        eventPublisher.publishEvent(userEventLog);
        return RestResponse.ok();
    }

    @PostMapping("update")
    @ApiOperation("用户更新")
    public RestResponse update(@RequestBody @Valid UserUpdateVM userModel) {
        User user = userService.getById(getCurrentUser().getId());
        modelMapper.map(userModel, user);
        user.setModifyTime(new Date());
        UserEventLog userEventLog = new UserEventLog(user.getId(), user.getUserName(), user.getRealName(), new Date());
        userEventLog.setContent(user.getUserName() + "update user info");
        eventPublisher.publishEvent(new UserEvent(userEventLog));
        return RestResponse.ok();
    }

    @PostMapping("current")
    public RestResponse<UserResponseVM> current() {
        User currentUser = getCurrentUser();
        UserResponseVM user = UserResponseVM.from(currentUser);
        return RestResponse.ok(user);
    }

    @PostMapping("message/unreadCount")
    public RestResponse unreadCount() {

    }


}
