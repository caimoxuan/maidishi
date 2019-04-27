package com.mds.matrix.customer.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mds.matrix.customer.model.CustomerHistory;

@Repository
public interface CustomerHistoryDao{

	List<CustomerHistory> select(CustomerHistory customerHistory);

	int update(CustomerHistory customerHistory);

	int insert(CustomerHistory customerHistory);

	int delete(CustomerHistory customerHistory);

	CustomerHistory getById(Long id);
}