package com.xworkz.landrecords.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class DbConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean localEntityManagerFactoryBean() {
		
		LocalEntityManagerFactoryBean lemfb = new LocalEntityManagerFactoryBean();
		lemfb.setPersistenceUnitName("Land Records");
		return lemfb;
		
	}

}
