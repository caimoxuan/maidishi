package com.mds.matrix.customer.controller;

import com.github.pagehelper.Page;
import com.mds.matrix.common.constant.ApiResult;
import com.mds.matrix.customer.model.Car;
import com.mds.matrix.customer.model.RentHistory;
import com.mds.matrix.customer.service.HistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cmx
 * @Date 2019/5/4 14:43
 */
@Slf4j
@RestController
@RequestMapping("/cus/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResult<List<RentHistory>> listHistory(@RequestParam int pageNo,
                                             @RequestParam int pageSize) {
        RentHistory history = new RentHistory();
        ApiResult<List<RentHistory>> result = new ApiResult<>();
        Page<RentHistory> resultList = historyService.list(history, pageNo, pageSize);
        result.setData(resultList.getResult());
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ApiResult<RentHistory> getHistory(@RequestParam Long historyId) {
        ApiResult<RentHistory> result = new ApiResult<>();
        result.setData(historyService.getById(historyId));
        return result;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult<String> createHistory(@RequestParam String openId){
        ApiResult<String> result = new ApiResult<>();
        RentHistory history = new RentHistory();
        history.setOperatorUserId(openId);
        historyService.insert(history);
        result.setData("success");
        return result;
    }

}
