package com.mds.matrix.customer.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mds.matrix.customer.mapper.MarkBookDao;
import com.mds.matrix.customer.model.MarkBook;
import com.mds.matrix.customer.service.MarkBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmx
 * @Date 2019/5/4 12:03
 */
@Service
public class MarkBookServiceImpl implements MarkBookService {

    @Autowired
    private MarkBookDao markBookDao;

    @Override
    public int insert(MarkBook markBook) {
        return markBookDao.insert(markBook);
    }

    @Override
    public int update(MarkBook markBook) {
        return markBookDao.update(markBook);
    }

    @Override
    public Page<MarkBook> list(MarkBook markBook, int pageNo, int pageSize) {
        return PageHelper.startPage(pageNo, pageSize).doSelectPage(() -> markBookDao.select(markBook));
    }

    @Override
    public MarkBook getById(Long markBookId) {
        return markBookDao.getById(markBookId);
    }

    @Override
    public int delete(Long markBookId) {
        return markBookDao.delete(markBookId);
    }
}
