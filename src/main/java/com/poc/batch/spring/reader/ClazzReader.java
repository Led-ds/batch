package com.poc.batch.spring.reader;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.poc.batch.spring.BeanFactory;
import com.poc.batch.spring.model.ClazzModel;
import com.poc.batch.spring.model.ClazzModelMapper;
import com.poc.batch.spring.util.QueryFix;

public class ClazzReader {

	@Autowired
	private BeanFactory factory;	
	private JdbcCursorItemReader<ClazzModel> reader;
	

	public JdbcCursorItemReader<ClazzModel> readerModel(){
		reader = new JdbcCursorItemReader<>();
		
		reader.setDataSource(factory.dataSource());
		reader.setSql(QueryFix.SELECT_TB);
		reader.setRowMapper(new ClazzModelMapper());
		
		return reader;
	}
}
