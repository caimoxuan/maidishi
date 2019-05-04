package com.mds.matrix.common.enums;

import com.mds.matrix.common.enums.handler.EnumInf;
import lombok.Getter;

/**
 * @author cmx
 * @Date 2019/5/4 17:46
 */
@Getter
public enum MarkType implements EnumInf {

    TYPE_RIDER(0, "RIDER"),
    TYPE_CAR(1, "CAR"),
    TYPE_BATTERY(2, "BATTERY");

    MarkType(int code, String message){
        this.code = code;
        this.message = message;
    }

    private int code;

    private String message;

}
