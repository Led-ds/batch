package com.poc.batch.spring.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:${PROPERTIES}")
public class PropertiesConfig {
	
	@Value("${datasource.url}")
	private String urlDataSource;
	
	@Value("${datasource.user}")
	private String userDataSource;
	
	@Value("${datasource.pass}")
	private String passDataSource;
	
	@Value("${datasource.driver}")
	private String driverDataSource;
	
	@Value("${transaction.isolation.level}")
	private String transactionIsolatoinLevel;
	
	@Value("${fetch.size}")
	private int fetchSize;
	
	@Value("${page.size}")
	private int pageSize;
	
	@Value("${chunk}")
	private int chunk;
	
	public String getUrlDataSource() {
		return urlDataSource;
	}
	public void setUrlDataSource(String urlDataSource) {
		this.urlDataSource = urlDataSource;
	}
	public String getUserDataSource() {
		return userDataSource;
	}
	public void setUserDataSource(String userDataSource) {
		this.userDataSource = userDataSource;
	}
	public String getPassDataSource() {
		return new String(Base64.getDecoder().decode(passDataSource), StandardCharsets.UTF_8);
	}
	public void setPassDataSource(String passDataSource) {
		this.passDataSource = passDataSource;
	}
	public String getDriverDataSource() {
		return driverDataSource;
	}
	public void setDriverDataSource(String driverDataSource) {
		this.driverDataSource = driverDataSource;
	}
	public String getTransactionIsolatoinLevel() {
		return transactionIsolatoinLevel;
	}
	public void setTransactionIsolatoinLevel(String transactionIsolatoinLevel) {
		this.transactionIsolatoinLevel = transactionIsolatoinLevel;
	}
	public int getFetchSize() {
		return fetchSize;
	}
	public void setFetchSize(int fetchSize) {
		this.fetchSize = fetchSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getChunk() {
		return chunk;
	}
	public void setChunk(int chunk) {
		this.chunk = chunk;
	}
}
