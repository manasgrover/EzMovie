package com.easymovie.data.config;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Manas Grover
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.easymovie.repository.sql"})
@EnableTransactionManagement(proxyTargetClass = true)
public class DataSourceConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

	@Bean
	public DataSource dataSource() {
		return getDataSource();
	}

	public DataSource getDataSource() {
		ComboPooledDataSource dataSource = createNewC3P0Instance();
		dataSource.setJdbcUrl("");
		dataSource.setUser("");
		dataSource.setPassword("");
		return dataSource;
	}


	private ComboPooledDataSource createNewC3P0Instance() {
		ComboPooledDataSource instance = new ComboPooledDataSource();
		try {
			instance.setDriverClass("");
			instance.setPreferredTestQuery("SELECT 1");
			instance.setTestConnectionOnCheckin(true);
			instance.setInitialPoolSize(1);
			instance.setMaxPoolSize(3);
			instance.setAcquireIncrement(1);
			instance.setMaxIdleTime(900);
			instance.setMaxIdleTimeExcessConnections(550);
			instance.setIdleConnectionTestPeriod(30);
			instance.setMaxConnectionAge(1500);
		} catch (Exception e) {
			LOGGER.error("Exception occured when retrieving dataSource", e);
		}
		return instance;
	}
}
