package com.mds.matrix.customer.service;

import com.github.pagehelper.Page;
import com.mds.matrix.customer.model.Battery;
import com.mds.matrix.customer.model.BatteryDetail;

/**
 * @author cmx
 * @Date 2019/5/4 11:40
 */
public interface BatteryService {

    int insert(Battery battery);

    int update(Battery battery);

    Page<Battery> list(Battery battery, int pageNo, int pageSize);

    Battery getById(Long batteryId);

    BatteryDetail getByDetailId(Long detailId);

}
