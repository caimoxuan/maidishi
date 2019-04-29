package com.mds.matrix.common.exception;

/**
 * @author cmx
 * @Date 2019/4/29 23:56
 */
public class MdsException extends RuntimeException implements ExceptionInterface{

    private String message;

    private int code;

    public MdsException(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
