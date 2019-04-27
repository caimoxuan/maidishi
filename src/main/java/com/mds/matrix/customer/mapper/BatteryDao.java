package com.mds.matrix.customer.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mds.matrix.customer.model.Battery;

@Repository
public interface BatteryDao{

	List<Battery> select(Battery battery);

	int update(Battery battery);

	int insert(Battery battery);

	int delete(Battery battery);

	Battery getById(Long id);
}