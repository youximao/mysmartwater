package com.iot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MysmartwaterApplication {

	public static void main(String[] args) {

		System.out.println(System.getProperty("os.name"));
		SpringApplication.run(MysmartwaterApplication.class, args);
	}
}
