package com.nt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nt.model.ExamResult;

public class ExamResultMapper implements RowMapper<ExamResult> {

	@Override
	public ExamResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExamResult result=null;
		result=new ExamResult();
		result.setId(rs.getInt(1));
		result.setDob(rs.getDate(2));
		result.setPercentage(rs.getDouble(3));
		result.setSem(rs.getInt(4));
		return result;
	}

}
