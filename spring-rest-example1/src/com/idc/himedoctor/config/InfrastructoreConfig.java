package com.idc.himedoctor.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages={"com.idc.homedoctor.service"})
@EnableJpaRepositories(("com.idc.homedoctor.respository"))
public class InfrastructoreConfig
{
	@Bean
	public DataSource datasoursce()
	{
		DriverManagerDataSource datasoursce=new DriverManagerDataSource();
		datasoursce.setDriverClassName("com.mysql.jdbc.Driver");
		datasoursce.setUrl("jdbc:mysql://localhost:3306/home");
		datasoursce.setUsername("root");
		datasoursce.setPassword("root");
		return datasoursce;
	}
	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter  JpaVendorAdapter=new HibernateJpaVendorAdapter();
		JpaVendorAdapter.setDatabase(org.springframework.orm.jpa.vendor.Database.MYSQL);
		JpaVendorAdapter.setGenerateDdl(true);
		return JpaVendorAdapter;
				
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter)
	{
		LocalContainerEntityManagerFactoryBean factorybean=new LocalContainerEntityManagerFactoryBean();
		factorybean.setDataSource(dataSource);
		factorybean.setJpaVendorAdapter(jpaVendorAdapter);
		factorybean.setPackagesToScan("com.idc.homedoctor.model");
		return factorybean;
	}
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory factoryBean)
	{
		return new JpaTransactionManager(factoryBean);
	}
	
	

}
