package com.poc.batch.spring;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.poc.batch.spring.steps.ClazzWriter;
import com.poc.batch.spring.util.PropertiesConfig;

public class BeanFactory extends DefaultBatchConfigurer{
	
	@Autowired
	public PropertiesConfig config;
	
	private DataSource dataSource;
	private ClazzWriter clazzWriter;
	
	public DataSource dataSource() {
		DriverManagerDataSource datasource;
		if(this.dataSource == null) {
			datasource = new DriverManagerDataSource();
			datasource.setUrl(config.getUrlDataSource());
			datasource.setUsername(config.getUserDataSource());
			datasource.setPassword(config.getPassDataSource());
			datasource.setDriverClassName(config.getDriverDataSource());
			
			this.dataSource = datasource;
		}
		
		return this.dataSource;
	}
	
	public ClazzWriter getWriter() {
		if(null == this.clazzWriter) {
			this.clazzWriter = new ClazzWriter();
		}
		
		this.clazzWriter.setDataSource(dataSource());
		
		return this.clazzWriter;
	}

	public void setClazzWriter(ClazzWriter clazzWriter) {
		this.clazzWriter = clazzWriter;
	}
	
}
