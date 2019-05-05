package com.mds.matrix.common.controller;

import com.mds.matrix.common.constant.ApiResult;
import com.mds.matrix.common.constant.CustomerConstant;
import com.mds.matrix.common.constant.ErrorEnum;
import com.mds.matrix.customer.model.User;
import com.mds.matrix.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cmx
 * @date 2019/5/5
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ApiResult<String> login(@RequestParam String openId,
                                   HttpServletRequest request){
        ApiResult<String> result = new ApiResult<>();
        User user = customerService.getById(openId);
        if(user == null){
            result.fail(ErrorEnum.FORBIDDEN_ACCESS);
            return result;
        }
        request.getSession().setAttribute(CustomerConstant.SESSION_OPEN_ID, openId);
        result.setData("success");
        return result;
    }


}
