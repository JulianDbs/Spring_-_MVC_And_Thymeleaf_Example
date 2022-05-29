package com.juliandbs.springmvcthymeleafexample.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
*	@author JulianDbs
*/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home/home");
		registry.addViewController("/home").setViewName("home/home");
		registry.addViewController("/article").setViewName("article/article");
		registry.addViewController("/articles").setViewName("articles/articles");
		registry.addViewController("/about").setViewName("about/about");
	}
}
