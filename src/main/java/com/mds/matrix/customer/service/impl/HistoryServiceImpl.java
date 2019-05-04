package com.mds.matrix.customer.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mds.matrix.customer.mapper.RentHistoryDao;
import com.mds.matrix.customer.model.RentHistory;
import com.mds.matrix.customer.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmx
 * @Date 2019/5/4 12:00
 */
@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private RentHistoryDao rentHistoryDao;

    @Override
    public int insert(RentHistory history) {
        return rentHistoryDao.insert(history);
    }

    @Override
    public int update(RentHistory history) {
        return rentHistoryDao.update(history);
    }

    @Override
    public Page<RentHistory> list(RentHistory history, int pageNo, int pageSize) {
        return PageHelper.startPage(pageNo, pageSize).doSelectPage(() -> rentHistoryDao.select(history));
    }

    @Override
    public RentHistory getById(Long historyId) {
        return rentHistoryDao.getById(historyId);
    }
}
