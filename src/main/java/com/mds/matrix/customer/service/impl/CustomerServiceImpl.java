package com.mds.matrix.customer.service.impl;

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
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public List<User> listUser(User user) {
        return userDao.select(user);
    }
}
