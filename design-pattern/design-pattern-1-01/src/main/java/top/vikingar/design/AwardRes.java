package top.vikingar.design;

/**
 * @author vikingar
 * @time 2024/6/20 12:40
 * @description
 */
public class AwardRes {

    private String code;

    private String info;

    public AwardRes(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
