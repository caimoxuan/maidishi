package com.mds.matrix.customer.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mds.matrix.customer.mapper.ProductDao;
import com.mds.matrix.customer.model.Product;
import com.mds.matrix.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmx
 * @Date 2019/5/4 12:06
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public int insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }

    @Override
    public Page<Product> list(Product product, int pageNo, int pageSize) {
        return PageHelper.startPage(pageNo, pageSize).doSelectPage(() -> productDao.select(product));
    }

    @Override
    public Product getById(Long productId) {
        return productDao.getById(productId);
    }
}
