package com.satisfaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.satisfaction.compute.KnackSnap;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses=KnackSnap.class)
public class GordonSatisfactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GordonSatisfactionApplication.class, args);
	}
}
