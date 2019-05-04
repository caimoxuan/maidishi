package com.mds.matrix.customer.service;

import com.github.pagehelper.Page;
import com.mds.matrix.customer.model.Product;

/**
 * @author cmx
 * @Date 2019/5/4 11:42
 */
public interface ProductService {

    int insert(Product product);

    int update(Product product);

    Page<Product> list(Product product, int pageNo, int pageSize);

    Product getById(Long productId);

}
