package com.mds.matrix.customer.controller;

import com.github.pagehelper.Page;
import com.mds.matrix.common.constant.ApiResult;
import com.mds.matrix.common.enums.MarkType;
import com.mds.matrix.customer.model.MarkBook;
import com.mds.matrix.customer.service.MarkBookService;
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
@RequestMapping("/cus/markBook")
public class MarkBookController {

    @Autowired
    private MarkBookService markBookService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResult<List<MarkBook>> listMarkBook(@RequestParam int pageNo,
                                                  @RequestParam int pageSize) {
        MarkBook markBook = new MarkBook();
        ApiResult<List<MarkBook>> result = new ApiResult<>();
        Page<MarkBook> resultList = markBookService.list(markBook, pageNo, pageSize);
        result.setData(resultList.getResult());
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ApiResult<MarkBook> getMarkBook(@RequestParam Long markBookId) {
        ApiResult<MarkBook> result = new ApiResult<>();
        result.setData(markBookService.getById(markBookId));
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ApiResult<String> deleteMarkBook(@RequestParam Long markBookId) {
        ApiResult<String> result = new ApiResult<>();
        markBookService.delete(markBookId);
        result.setData("success");
        return result;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult<String> createMarkBook(@RequestParam String openId,
                                            @RequestParam MarkType markType,
                                            @RequestParam String markId,
                                            @RequestParam String markName,
                                            @RequestParam String extra){
        ApiResult<String> result = new ApiResult<>();
        MarkBook markBook = new MarkBook();
        markBook.setOpenId(openId);
        markBook.setMarkId(markId);
        markBook.setMarkName(markName);
        markBook.setMarkType(markType);
        markBook.setExtra(extra);
        markBookService.insert(markBook);
        result.setData("success");
        return result;
    }


}
