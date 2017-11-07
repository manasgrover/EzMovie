package com.easymovie.data.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.easymovie" }, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes={ PersistenceConfig.class,}))
@Import(PersistenceConfigTest.class)
public class CoreTestConfig {}