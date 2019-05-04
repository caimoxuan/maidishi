package com.mds.matrix.common.enums;

import com.mds.matrix.common.enums.handler.EnumInf;
import lombok.Getter;

/**
 * @author cmx
 * @Date 2019/5/4 21:55
 */
@Getter
public enum CarStatus implements EnumInf {

    UNUSED(0, "UNUSED"),
    RENTED(1, "RENTED"),
    SAILED(2, "SAILED"),
    OVERDUE(3, "OVERDUE"),
    DISCARD(8, "DISCARD"),
    ABNORMAL(9, "ABNORMAL");

    private int code;

    private String message;

    CarStatus(int code, String message){
        this.code = code;
        this.message = message;
    }

}
