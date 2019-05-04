package com.mds.matrix.customer.service;

import com.github.pagehelper.Page;
import com.mds.matrix.customer.model.Car;

/**
 * @author cmx
 * @Date 2019/5/4 11:41
 */
public interface CarService {

    int insert(Car car);

    int update(Car car);

    Page<Car> list(Car car, int pageNo, int pageSize);

    Car getById(Long carId);

}
