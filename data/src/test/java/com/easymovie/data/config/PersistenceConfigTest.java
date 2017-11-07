package com.easymovie.data.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.easymovie.data.repository")
@Configuration
//@Import(CouchBaseConfig.class)
public class PersistenceConfigTest {
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

	        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
	        dataSource.setUrl("jdbc:hsqldb:mem:testdb;sql.syntax_mys=true;DB_CLOSE_DELAY=-1");
	        dataSource.setUsername("manas");
	        dataSource.setPassword("manas");

	        
			return dataSource;
			
			/*
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			EmbeddedDatabase db = builder
				.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
				.build();
			return db;
			*/
		}


	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
		vendorAdapter.setDatabase(Database.HSQL);

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceUnitName("simple-jpa");
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setPackagesToScan("com.easymovie.data.entity");
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
		
	/*@Bean
	public ResourceDatabasePopulator databasePopulator() {
	    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.setSqlScriptEncoding("UTF-8");
	    populator.addScript(new ClassPathResource("testData.sql"));
	    return populator;
	}*/

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, "org.hibernate.dialect.HSQLDialect");
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, true);
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.hbm2ddl.import_files", "testData.sql");
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl.sqllog", "3");
		properties.put("hibernate.ejb.naming_strategy", "com.easymovie.data.NamingStrategy.EasyMovieNamingStrategy");
		properties.put("hibernate.implicit_naming_strategy", "com.easymovie.data.NamingStrategy.EasyMovieNamingStrategy");
		return properties;
	}
}
