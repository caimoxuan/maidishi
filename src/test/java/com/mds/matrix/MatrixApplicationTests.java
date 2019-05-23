package com.mds.matrix;

import com.mds.matrix.test.felid.service.TargetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatrixApplicationTests {

	@Autowired
	private TargetService targetService;

	@Test
	public void contextLoads() {

		System.out.println(targetService.listUser());

	}

}
