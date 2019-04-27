package com.mds.matrix.customer.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mds.matrix.customer.model.Car;

@Repository
public interface CarDao{

	List<Car> select(Car car);

	int update(Car car);

	int insert(Car car);

	int delete(Car car);

	Car getById(Long id);
}