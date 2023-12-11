package com.hz.web.ResponseEntiry;

public enum ResCode {
    SUCCESS(200), INVALID_TOKEN(401), FORBIDDEN(403), UNKNOWN_ERROR(500);

    private int value = 0;
    private ResCode(int value) {     //必须是private的，否则编译错误
        this.value = value;
    }

    public static ResCode valueOf(int value) {    //手写的从int到enum的转换函数
        switch (value) {
            case 200:
                return SUCCESS;  // 成功
            case 401:
                return INVALID_TOKEN;  // token失效
            case 403:
                return FORBIDDEN;  // 没有权限
            default:
                return UNKNOWN_ERROR;  // 未知错误
        }
    }

    public int value() {
        return this.value;
    }
}
