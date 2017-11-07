package com.easymovie.data.config;


import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * @author Manas Grover
 *
 */

@Configuration
@Import({DataSourceConfig.class})
public class PersistenceConfig {
	
	
	public static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	public static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	public static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	public static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	public static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	public static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	public static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	
	@Autowired
	private DataSourceConfig dataSourceConfig;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(false);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		vendorAdapter.setDatabase(Database.MYSQL);
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSourceConfig.dataSource());
		entityManagerFactoryBean.setPersistenceUnitName("simple-jpa");
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setPackagesToScan("com.easymovie");
		entityManagerFactoryBean.setJpaProperties(hibProperties());

		return entityManagerFactoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		JpaDialect jpaDialect = new HibernateJpaDialect();
		transactionManager.setJpaDialect(jpaDialect);
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, "org.hibernate.dialect.MySQLDialect");
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, true);
		properties.put("hibernate.hbm2ddl.auto", "none");
		properties.put("hibernate.ejb.naming_strategy", "com.easymovie.data.NamingStrategy.EasyMovieNamingStrategy");
		properties.put("hibernate.implicit_naming_strategy", "com.easymovie.data.NamingStrategy.EasyMovieNamingStrategy");
		properties.put("hibernate.c3p0.idle_test_period", "30");
		return properties;
	}
	
}