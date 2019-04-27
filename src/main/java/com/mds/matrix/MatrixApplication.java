package com.mds.matrix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan({"com.mds.matrix.customer.mapper"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MatrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatrixApplication.class, args);
	}

}
