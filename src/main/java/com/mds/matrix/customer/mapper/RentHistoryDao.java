package com.mds.matrix.customer.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mds.matrix.customer.model.RentHistory;

@Repository
public interface RentHistoryDao{

	List<RentHistory> select(RentHistory rentHistory);

	int update(RentHistory rentHistory);

	int insert(RentHistory rentHistory);

	int delete(RentHistory rentHistory);

	RentHistory getById(Long id);
}