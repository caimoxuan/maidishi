package com.mds.matrix.customer.controller;

import com.github.pagehelper.Page;
import com.mds.matrix.common.constant.ApiResult;
import com.mds.matrix.customer.model.Battery;
import com.mds.matrix.customer.model.Car;
import com.mds.matrix.customer.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cmx
 * @Date 2019/5/4 14:41
 */

@Slf4j
@RestController
@RequestMapping("/cus/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResult<List<Car>> listCar(@RequestParam int pageNo,
                                             @RequestParam int pageSize) {
        Car car = new Car();
        ApiResult<List<Car>> result = new ApiResult<>();
        Page<Car> resultList = carService.list(car, pageNo, pageSize);
        result.setData(resultList.getResult());
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ApiResult<Car> getCar(@RequestParam Long carId) {
        ApiResult<Car> result = new ApiResult<>();
        result.setData(carService.getById(carId));
        return result;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult<String> createCar(@RequestParam String carId){
        ApiResult<String> result = new ApiResult<>();
        Car car = new Car();
        car.setCarId(carId);
        carService.insert(car);
        result.setData("success");
        return result;
    }


}
