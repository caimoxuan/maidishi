package com.mds.matrix.common;

import com.mds.matrix.common.exception.ExceptionInterface;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cmx
 * @Date 2019/4/29 23:36
 */
@Data
public class ApiResult<T> implements Serializable {

    private Integer code;

    private String message;

    private Boolean success;

    private T data;

    public ApiResult(){
        this.code = 200;
        this.message = "success";
        this.success = true;
    }

    public void success(T data){
        this.data = data;
    }

    public void fail(ExceptionInterface ex){
        this.code = ex.getCode();
        this.message = ex.getMessage();
    }


}
