package com.mds.matrix.customer.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mds.matrix.customer.mapper.CarDao;
import com.mds.matrix.customer.model.Car;
import com.mds.matrix.customer.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmx
 * @Date 2019/5/4 11:56
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public int insert(Car car) {
        return carDao.insert(car);
    }

    @Override
    public int update(Car car) {
        return carDao.update(car);
    }

    @Override
    public Page<Car> list(Car car, int pageNo, int pageSize) {
        return PageHelper.startPage(pageNo, pageSize).doSelectPage(() -> carDao.select(car));
    }

    @Override
    public Car getById(Long carId) {
        return carDao.getById(carId);
    }
}
