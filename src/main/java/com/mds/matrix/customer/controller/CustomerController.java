package com.mds.matrix.customer.controller;

import com.github.pagehelper.Page;
import com.mds.matrix.common.constant.ApiResult;
import com.mds.matrix.customer.model.User;
import com.mds.matrix.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
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
    public ApiResult<List<User>> listCustomer(@RequestParam int pageNo,
                                              @RequestParam int pageSize) {
        log.info("get list customer : {}");
        User user = new User();
        ApiResult<List<User>> result = new ApiResult<>();
        Page<User> resultList = customerService.listUser(user, pageNo, pageSize);
        result.setData(resultList.getResult());
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ApiResult<User> getUser(@RequestParam String openId) {
        ApiResult<User> result = new ApiResult<>();
        result.setData(customerService.getById(openId));
        return result;
    }


}
