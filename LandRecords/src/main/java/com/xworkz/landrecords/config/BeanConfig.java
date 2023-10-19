package com.xworkz.landrecords.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.landrecords")
@EnableWebMvc
public class BeanConfig implements WebMvcConfigurer {
	
	public BeanConfig() {
		System.out.println("Bean Config is started");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addRedirectViewController("/", "Index.jsp");
	}
	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/" , ".jsp");
	}

}
