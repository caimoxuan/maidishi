package com.mds.matrix.customer.service;

import com.github.pagehelper.Page;
import com.mds.matrix.customer.model.MarkBook;

/**
 * @author cmx
 * @Date 2019/5/4 11:41
 */
public interface MarkBookService {

    int insert(MarkBook markBook);

    int update(MarkBook markBook);

    Page<MarkBook> list(MarkBook markBook, int pageNo, int pageSize);

    MarkBook getById(Long markBookId);

    int delete(Long markBookId);


}
