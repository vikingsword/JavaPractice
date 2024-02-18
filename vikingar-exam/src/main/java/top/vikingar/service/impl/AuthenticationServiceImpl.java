package top.vikingar.service.impl;

import org.springframework.stereotype.Service;
import top.vikingar.domain.User;
import top.vikingar.service.AuthenticationService;

/**
 * @author vikingar
 * @time 2024/2/18 22:56
 * @description
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public boolean authUser(String username, String password) {
        return false;
    }

    @Override
    public boolean authUser(User user, String username, String password) {
        return false;
    }

    @Override
    public String pwdEncode(String password) {
        return null;
    }

    @Override
    public String pwdDecode(String encodePwd) {
        return null;
    }
}
