package com.mds.matrix.customer.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mds.matrix.customer.model.Product;

@Repository
public interface ProductDao{

	List<Product> select(Product product);

	int update(Product product);

	int insert(Product product);

	int delete(Product product);

	Product getById(Long id);
}