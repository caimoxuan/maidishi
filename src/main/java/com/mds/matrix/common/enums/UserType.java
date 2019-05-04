package com.mds.matrix.common.enums;

import com.mds.matrix.common.enums.handler.EnumInf;
import lombok.Getter;

/**
 * @author cmx
 * @Date 2019/4/30 22:58
 */
public enum UserType implements EnumInf {

    MANAGER(0, "manager"),
    CUSTOMER(1, "customer"),
    DRIVER(2, "DRIVER");

    @Getter
    private int code;
    private String message;

    UserType(int code, String message){
        this.code = code;
        this.message = message;
    }

}
