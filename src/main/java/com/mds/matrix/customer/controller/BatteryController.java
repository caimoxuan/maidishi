package com.mds.matrix.customer.controller;

import com.github.pagehelper.Page;
import com.mds.matrix.common.constant.ApiResult;
import com.mds.matrix.common.constant.ErrorEnum;
import com.mds.matrix.common.enums.UserType;
import com.mds.matrix.customer.model.Battery;
import com.mds.matrix.customer.model.User;
import com.mds.matrix.customer.service.BatteryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cmx
 * @Date 2019/5/4 11:40
 */

@Slf4j
@RestController
@RequestMapping("/cus/battery")
public class BatteryController {

    @Autowired
    private BatteryService batteryService;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResult<List<Battery>> listBattery(@RequestParam int pageNo,
                                              @RequestParam int pageSize) {
        Battery battery = new Battery();
        ApiResult<List<Battery>> result = new ApiResult<>();
        Page<Battery> resultList = batteryService.list(battery, pageNo, pageSize);
        result.setData(resultList.getResult());
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ApiResult<Battery> getBattery(@RequestParam Long batteryId) {
        ApiResult<Battery> result = new ApiResult<>();
        result.setData(batteryService.getById(batteryId));
        return result;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult<String> createBattery(@RequestParam String batteryId,
                                    @RequestParam String carId){
        ApiResult<String> result = new ApiResult<>();
        Battery battery = new Battery();
        battery.setCarId(carId);
        battery.setBatteryId(batteryId);
        batteryService.insert(battery);
        result.setData("success");
        return result;
    }

}
