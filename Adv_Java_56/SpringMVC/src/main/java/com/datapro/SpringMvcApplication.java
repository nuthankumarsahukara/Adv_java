package com.datapro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringMvcApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringMvcApplication.class);
    } 
    
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
		System.out.println("Application Started.........");
	}

}
