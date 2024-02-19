package top.vikingar.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import top.vikingar.domain.User;
import top.vikingar.service.UserService;

/**
 * @author vikingar
 * @time 2024/2/19 11:18
 * @description
 */

@Component
public class WebContext {

    private static final String USER_ATTRIBUTES = "USER_ATTRIBUTES";

    private final UserService userService;

    @Autowired
    public WebContext(UserService userService) {
        this.userService = userService;
    }


    public User getCurrentUser() {
        User user = (User) RequestContextHolder.currentRequestAttributes().getAttribute(USER_ATTRIBUTES, RequestAttributes.SCOPE_REQUEST);
        if (null != user) {
            return user;
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            org.springframework.security.core.userdetails.User securityUser = (org.springframework.security.core.userdetails.User) principal;
            if (null == securityUser) {
                return null;
            }
            User user1 = userService.getUserByName(securityUser.getUsername());
            if (null != user1) {
                setCurrentUser(user1);
            }
            return user1;
        }
    }

    public void setCurrentUser(User user) {
        RequestContextHolder.currentRequestAttributes().setAttribute(USER_ATTRIBUTES, user, RequestAttributes.SCOPE_REQUEST);
    }

}
