package top.vikingar.base;

import lombok.Getter;

public enum SystemCode {
    OK(200, "successfully"),

    ERROR(500, "server error")
    ;

    @Getter
    int code;

    @Getter
    String msg;

    SystemCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
