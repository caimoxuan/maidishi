package com.mds.matrix.customer.controller;

import com.github.pagehelper.Page;
import com.mds.matrix.common.constant.ApiResult;
import com.mds.matrix.customer.model.MarkBook;
import com.mds.matrix.customer.model.Product;
import com.mds.matrix.customer.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cmx
 * @Date 2019/5/4 14:42
 */
@Slf4j
@RestController
@RequestMapping("/cus/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResult<List<Product>> listProduct(@RequestParam int pageNo,
                                                 @RequestParam int pageSize) {
        Product product = new Product();
        ApiResult<List<Product>> result = new ApiResult<>();
        Page<Product> resultList = productService.list(product, pageNo, pageSize);
        result.setData(resultList.getResult());
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ApiResult<Product> getProduct(@RequestParam Long markBookId) {
        ApiResult<Product> result = new ApiResult<>();
        result.setData(productService.getById(markBookId));
        return result;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult<String> createProduct(@RequestParam String productName){
        ApiResult<String> result = new ApiResult<>();
        Product product = new Product();
        product.setProductName(productName);
        productService.insert(product);
        result.setData("success");
        return result;
    }

}
