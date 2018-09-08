package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	private JdbcTemplate jt;
	

	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDegs(String condition) {
		List<Map<String,Object>> list=null;
		list=jt.queryForList("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+condition+" ORDER BY JOB");
		return list;
	}

}
