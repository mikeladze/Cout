package sout.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by ucha on 3/6/15.
 */
@Configuration
@ComponentScan(basePackages = {"."})
@EnableTransactionManagement
public class SpringDBConfig {

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(this.entityManagerFactory().getObject());

		return transactionManager;
	}

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		HibernateJpaSessionFactoryBean sessionFactory = new HibernateJpaSessionFactoryBean();

		return sessionFactory;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setPackagesToScan(".");
		entityManagerFactory.setDataSource(this.dataSource());
		entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
			{
				String dialect = "org.hibernate.dialect.Oracle10gDialect";
				this.setDatabasePlatform(dialect);
			}
		};

		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

		return entityManagerFactory;
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}
}