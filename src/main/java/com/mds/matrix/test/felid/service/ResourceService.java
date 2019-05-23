package com.mds.matrix.test.felid.service;

import com.mds.matrix.customer.model.User;
import org.springframework.stereotype.Service;

/**
 * @author cmx
 * @Date 2019/5/23 21:50
 */
@Service
public class ResourceService {


    public User getUser(String openId){
        if("1234123".equals(openId)){
            User user = new User();
            user.setNickName("jijiji");
            return user;
        }else if("1234124".equals(openId)){
            User user = new User();
            user.setNickName("hahaha");
            return user;
        }
        return null;
    }



}
