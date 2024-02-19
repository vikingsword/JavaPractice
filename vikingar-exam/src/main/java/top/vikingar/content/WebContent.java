package top.vikingar.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.vikingar.service.UserService;

/**
 * @author vikingar
 * @time 2024/2/19 11:18
 * @description
 */

@Component
public class WebContent {

    private static final String USER_ATTRIBUTES = "USER_ATTRIBUTES";

    private final UserService userService;

    @Autowired
    public WebContent(UserService userService) {
        this.userService = userService;
    }


    public void getCurrentUser() {

    }
}
