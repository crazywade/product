package com.hcnay.product;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//定义扫描包
@SpringBootApplication(scanBasePackages = "com.hcnay.product")
//定义扫描MyBatis接口
@MapperScan(annotationClass = Mapper.class,basePackages = "com.hcnay.product")
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
