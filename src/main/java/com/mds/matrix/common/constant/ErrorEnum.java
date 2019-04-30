package com.mds.matrix.common.constant;

import com.mds.matrix.common.exception.MdsException;
import org.springframework.http.HttpStatus;

/**
 * @author cmx
 * @Date 2019/4/29 23:58
 */
public class ErrorEnum {

    public static final MdsException SYSTEM_ERROR = new MdsException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统异常");

}
