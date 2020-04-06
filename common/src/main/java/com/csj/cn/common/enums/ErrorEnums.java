package com.csj.cn.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum  ErrorEnums implements IErrorCode {
    ERROR_PARAM("E_001","参数类型异常"),
    EMPTY_PARAM("E_002","参数为空异常"),
    EMPTY_USER_NAME("E_003","用户名不存在"),
    ERROR_USER_PWD("E_004","密码错误");
    private String errorCode;
    private String errorMessage;

    @Override
    public String toString() {
        return "ErrorEnums{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
