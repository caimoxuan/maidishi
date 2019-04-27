package com.mds.matrix.customer.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mds.matrix.customer.model.User;

@Repository
public interface UserDao{

	List<User> select(User user);

	int update(User user);

	int insert(User user);

	int delete(User user);

	User getById(Long id);
}