package com.poc.batch.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ClazzModelMapper implements RowMapper<ClazzModel>{

	private ClazzModel model;
	
	@Override
	public ClazzModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		model = new ClazzModel();
		model.setNameAny(rs.getString("NAME_COLUMN_TABLE"));
		model.setCodeAny(rs.getString("NAME_COLUMN_TABLE"));
		
		return model;
	}

}
