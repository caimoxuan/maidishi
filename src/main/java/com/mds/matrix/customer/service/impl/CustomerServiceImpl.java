package com.mds.matrix.customer.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mds.matrix.customer.mapper.UserDao;
import com.mds.matrix.customer.model.User;
import com.mds.matrix.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cmx
 * @Date 2019/4/27 22:42
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserDao userDao;


    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public Page<User> listUser(User user, int pageNo, int pageSize) {
        return PageHelper.startPage(pageNo, pageSize).doSelectPage(() -> userDao.select(user));
    }

    @Override
    public User getById(String openId) {
        return userDao.getById(openId);
    }
}
