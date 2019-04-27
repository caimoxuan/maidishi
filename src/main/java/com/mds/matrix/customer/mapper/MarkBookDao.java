package com.mds.matrix.customer.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mds.matrix.customer.model.MarkBook;

@Repository
public interface MarkBookDao{

	List<MarkBook> select(MarkBook markBook);

	int update(MarkBook markBook);

	int insert(MarkBook markBook);

	int delete(MarkBook markBook);

	MarkBook getById(Long id);
}