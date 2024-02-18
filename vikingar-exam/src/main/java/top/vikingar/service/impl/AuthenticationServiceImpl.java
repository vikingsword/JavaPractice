package top.vikingar.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vikingar.config.SystemConfig;
import top.vikingar.domain.User;
import top.vikingar.service.AuthenticationService;
import top.vikingar.service.UserService;
import top.vikingar.utils.RsaUtil;

/**
 * @author vikingar
 * @time 2024/2/18 22:56
 * @description
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final SystemConfig systemConfig;

    @Autowired
    public AuthenticationServiceImpl(UserService userService, SystemConfig systemConfig) {
        this.userService = userService;
        this.systemConfig = systemConfig;
    }

    @Override
    public boolean authUser(String username, String password) {
        User user = userService.getUserByName(username);
        return authUser(user, username, password);
    }

    @Override
    public boolean authUser(User user, String username, String password) {
        if (null == user) {
            return false;
        }
        String encodePwd = user.getPassword();
        if (encodePwd == null || encodePwd.isEmpty()) {
            return false;
        }
        String decodePwd = pwdDecode(encodePwd);
        return decodePwd.equals(password);
    }

    @Override
    public String pwdEncode(String password) {
        return RsaUtil.rsaEncode(systemConfig.getPwdKey().getPublicKey(), password);
    }

    @Override
    public String pwdDecode(String encodePwd) {
        return RsaUtil.rsaDecode(systemConfig.getPwdKey().getPrivateKey(), encodePwd);
    }

}
