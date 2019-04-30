package com.mds.matrix.customer.service;

import com.github.pagehelper.Page;
import com.mds.matrix.customer.model.User;

import java.util.List;

/**
 * @author cmx
 * @Date 2019/4/27 22:40
 */
public interface CustomerService {

    int insert(User user);

    int update(User user);

    Page<User> listUser(User user, int pageNo, int pageSize);

    User getById(String openId);

}
