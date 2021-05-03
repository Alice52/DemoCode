package cn.edu.ntu.javaee.boot.common.model;

import cn.edu.ntu.javaee.boot.common.enumeration.HttpErrorCode;

import javax.validation.constraints.NotNull;

public class JsonObject {

    private Object data;
    private String msg;
    @NotNull private HttpErrorCode errorCode;

    public JsonObject() {}

    public JsonObject(HttpErrorCode errorCode, String msg, Object data) {
        this.data = data;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonObject)) return false;

        JsonObject that = (JsonObject) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;
        return errorCode == that.errorCode;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JsonObject{"
                + "data="
                + data
                + ", msg='"
                + msg
                + '\''
                + ", errorCode="
                + errorCode
                + '}';
    }
}
