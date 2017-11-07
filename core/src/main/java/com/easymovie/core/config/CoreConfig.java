package com.easymovie.core.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.easymovie.data.config.PersistenceConfig;

@Configuration
@ComponentScan(basePackages = "com.easymovie")
@EnableAspectJAutoProxy(proxyTargetClass=true)
//@EnableCaching
@Import({PersistenceConfig.class})
public class CoreConfig{}
