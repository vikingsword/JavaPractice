package top.vikingar.base;

/**
 * @author vikingar
 * @time 2024/2/16 17:19
 * @description basic response of restful api
 */
public class RestResponse<T> {
    private int code;

    private String message;

    private T data;

    public RestResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static RestResponse ok() {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse(systemCode.getCode(), systemCode.getMsg());
    }

    public static <R> RestResponse<R> ok(R response) {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMsg(), response);
    }

    public static RestResponse fail() {
        SystemCode systemCode = SystemCode.ERROR;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMsg());
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
