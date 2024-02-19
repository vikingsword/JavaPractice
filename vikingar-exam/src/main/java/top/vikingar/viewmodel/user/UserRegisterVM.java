package top.vikingar.viewmodel.user;

import lombok.NonNull;

/**
 * @author vikingar
 * @time 2024/2/18 22:32
 * @description
 */
public class UserRegisterVM {

    @NotBlank
    private String userName;

    private String passWord;

    private String userLevel;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
}
