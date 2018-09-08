package com.nt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nt.model.OExamResult;

public class ExamResultMapper implements RowMapper<OExamResult> {

	@Override
	public OExamResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		OExamResult result=null;
		result=new OExamResult();
		result.setId(rs.getInt(1));
		result.setDob(rs.getDate(2));
		result.setPercentage(rs.getDouble(3));
		result.setSem(rs.getInt(4));
		return result;
	}

}
