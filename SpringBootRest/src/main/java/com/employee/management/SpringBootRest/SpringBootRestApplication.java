package com.employee.management.SpringBootRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
@EnableWebSecurity
@EnableCaching
@ComponentScan({"com.employee.management.controller,com.employee.management.bean,com.employee.management.securityImpl,com.employee.management.exception"})
public class SpringBootRestApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(SpringBootRestApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
		System.out.println("hii");
	}

}

	