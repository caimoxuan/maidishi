package com.mds.matrix.customer.service;

import com.github.pagehelper.Page;
import com.mds.matrix.customer.model.RentHistory;

/**
 * @author cmx
 * @Date 2019/5/4 11:41
 */
public interface HistoryService {

    int insert(RentHistory history);

    int update(RentHistory history);

    Page<RentHistory> list(RentHistory history, int pageNo, int pageSize);

    RentHistory getById(Long historyId);

}
