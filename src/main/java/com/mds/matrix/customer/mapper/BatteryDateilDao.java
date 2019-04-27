package com.mds.matrix.customer.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mds.matrix.customer.model.BatteryDateil;

@Repository
public interface BatteryDateilDao{

	List<BatteryDateil> select(BatteryDateil batteryDateil);

	int update(BatteryDateil batteryDateil);

	int insert(BatteryDateil batteryDateil);

	int delete(BatteryDateil batteryDateil);

	BatteryDateil getById(Long id);
}