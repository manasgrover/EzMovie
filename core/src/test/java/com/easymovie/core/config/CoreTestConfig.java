package com.easymovie.core.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import com.easymovie.data.config.PersistenceConfig;

@Configuration
@ComponentScan(basePackages = { "com.easymovie" }, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes={ PersistenceConfig.class,}))
@Import(PersistenceConfigTest.class)
public class CoreTestConfig {}