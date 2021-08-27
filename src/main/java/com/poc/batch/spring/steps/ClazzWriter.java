package com.poc.batch.spring.steps;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.poc.batch.spring.model.ClazzModel;
import com.poc.batch.spring.util.QueryFix;

@Component
public class ClazzWriter implements ItemWriter<ClazzModel>{

	@Autowired
	private DataSource dataSource;
	
	protected static final Log logger = LogFactory.getLog(ClazzWriter.class);
	
	private JdbcTemplate jdbc;
	
	@Override
	public void write(List<? extends ClazzModel> items) throws Exception {
		jdbc = new JdbcTemplate(dataSource);
		
		try {
			for (ClazzModel clazzModel : items) {
				
				int status = jdbc.update(QueryFix.UPDATE_TB, new Object[] {"AQUI PASSAMOS OS PARAMETROS PARA CLAUSULA WHERE {?, ?, ?}"});
				
				if(status != 0) {
					
				}else {
					logger.warn("Not Found");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

}
