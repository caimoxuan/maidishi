package com.mds.matrix.customer.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mds.matrix.customer.mapper.BatteryDao;
import com.mds.matrix.customer.mapper.BatteryDetailDao;
import com.mds.matrix.customer.model.Battery;
import com.mds.matrix.customer.model.BatteryDetail;
import com.mds.matrix.customer.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmx
 * @Date 2019/5/4 11:50
 */
@Service
public class BatteryServiceImpl implements BatteryService {

    @Autowired
    private BatteryDao batteryDao;
    @Autowired
    private BatteryDetailDao batteryDetailDao;

    @Override
    public int insert(Battery battery) {
        return batteryDao.insert(battery);
    }

    @Override
    public int update(Battery battery) {
        return batteryDao.update(battery);
    }

    @Override
    public Page<Battery> list(Battery battery, int pageNo, int pageSize) {
        return PageHelper.startPage(pageNo, pageSize).doSelectPage(() -> batteryDao.select(battery));
    }

    @Override
    public Battery getById(Long batteryId) {
        return batteryDao.getById(batteryId);
    }

    @Override
    public BatteryDetail getByDetailId(Long detailId) {
        return batteryDetailDao.getById(detailId);
    }
}
