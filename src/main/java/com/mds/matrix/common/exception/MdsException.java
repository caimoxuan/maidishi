package com.mds.matrix.common.exception;

import lombok.Getter;

/**
 * @author cmx
 * @Date 2019/4/29 23:56
 */
@Getter
public class MdsException extends RuntimeException implements ExceptionInterface{

    private String message;

    private int code;

    public MdsException(int code, String message){
        this.code = code;
        this.message = message;
    }

}
