package com.mds.matrix.customer.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mds.matrix.customer.model.BatteryDetail;

@Repository
public interface BatteryDetailDao{

	List<BatteryDetail> select(BatteryDetail batteryDetail);

	int update(BatteryDetail batteryDetail);

	int insert(BatteryDetail batteryDetail);

	int delete(BatteryDetail batteryDetail);

	BatteryDetail getById(Long id);
}