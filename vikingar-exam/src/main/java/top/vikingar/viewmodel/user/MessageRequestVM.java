package top.vikingar.viewmodel.user;


import top.vikingar.base.BasePage;

public class MessageRequestVM extends BasePage {

    private Integer receiveUserId;

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }
}
