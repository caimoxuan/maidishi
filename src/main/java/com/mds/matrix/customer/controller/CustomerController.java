package com.mds.matrix.customer.controller;

import com.mds.matrix.common.ApiResult;
import com.mds.matrix.customer.model.User;
import com.mds.matrix.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cmx
 * @Date 2019/4/27 23:02
 */
@Slf4j
@RestController
@RequestMapping("/cus/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResult<List<User>> listCustomer(@RequestParam String openId) {
        log.info("get list customer : {}", openId);
        User user = new User();
        user.setOpenId(openId);
        ApiResult<List<User>> result = new ApiResult<>();
        result.setData(customerService.listUser(user));
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResult<User> getUser(@RequestParam String openId) {
        ApiResult<User> result = new ApiResult<>();
        result.setData(customerService.getById(openId));
        return result;
    }


}
