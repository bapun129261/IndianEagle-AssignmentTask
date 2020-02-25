package com.assign.Test;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ComponentScan("com.app")
public class Assignment1_E_CommerceWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment1_E_CommerceWebsiteApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://iedevdb.cju8h0qbqt75.ap-south-1.rds.amazonaws.com:3306/training");
		dataSource.setUsername("dbadmin");
		dataSource.setPassword("dbadmin123");
		return dataSource;
	}

	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("");
//		resolver.setSuffix(".jsp");
		return null;
	}
}
