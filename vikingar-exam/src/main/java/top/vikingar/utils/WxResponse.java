package top.vikingar.utils;


import lombok.Getter;

import java.io.Serializable;


public class WxResponse implements Serializable {
    /**
     * -- GETTER --
     *  Gets serial version uid.
     *
     * @return the serial version uid
     */
    @Getter
    private static final long serialVersionUID = -8496869159673561976L;
    /**
     * -- GETTER --
     *  Gets session key.
     *
     * @return the session key
     */
    @Getter
    private String session_key;
    /**
     * -- GETTER --
     *  Gets openid.
     *
     * @return the openid
     */
    @Getter
    private String openid;

    /**
     * Sets session key.
     *
     * @param session_key the session key
     */
    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    /**
     * Sets openid.
     *
     * @param openid the openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
