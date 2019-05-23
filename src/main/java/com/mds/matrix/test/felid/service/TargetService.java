package com.mds.matrix.test.felid.service;

import com.mds.matrix.common.enums.UserType;
import com.mds.matrix.customer.model.User;
import com.mds.matrix.test.felid.annotion.NeedSetFelidValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmx
 * @Date 2019/5/23 21:47
 */
@Service
public class TargetService {


    @NeedSetFelidValue
    public List<User> listUser(){

        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setOpenId("1234123");
        user1.setUserType(UserType.CUSTOMER);
        user1.setMobile(13777485861L);

        User user2 = new User();
        user2.setOpenId("1234124");
        user2.setUserType(UserType.CUSTOMER);
        user2.setMobile(13777485861L);

        userList.add(user1);
        userList.add(user2);
        return userList;
    }

}
