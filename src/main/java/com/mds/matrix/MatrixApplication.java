package com.mds.matrix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * @author cmx
 */
@SpringBootApplication
@MapperScan({"com.mds.matrix.customer.mapper"})
@ServletComponentScan(basePackages = {"com.mds.matrix.common.filter"})
public class MatrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(MatrixApplication.class, args);
	}
}
