package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_EMPsCOUNTBYRANGE="SELECT COUNT(*) FROM EMP WHERE EMPNO>=:min AND EMPNO<=:max";
	private static final String  GET_EMps_BY_DESGs="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(:desg1,:desg2,:desg3)";
	private static final String  INSERT_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(:eno,:ename,:desg,:salary)";
	@Autowired
	private NamedParameterJdbcTemplate npjt;

	@Override
	public int getEmpsCountByEnoRange(int start, int end) {
		Map<String,Object> map=null;
		int count=0;
		//prepare paramMap
		map=new HashMap();
		map.put("min",start);
		map.put("max",end);
		//execute query
		count=npjt.queryForObject(GET_EMPsCOUNTBYRANGE, map,Integer.class);
		return count;
	}

	@Override
	public List<EmployeeBO> getEmpsByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=null;
		MapSqlParameterSource msps=null;
		//create SqlParameterSource obj having param names and Values
		msps=new MapSqlParameterSource();
		msps.addValue("desg1",desg1);
		msps.addValue("desg2", desg2);
		msps.addValue("desg3",desg3);
		//execute the SQL Query		
		listBO=npjt.query(GET_EMps_BY_DESGs, msps,
				                          rs->{
				                        	  List<EmployeeBO> listBO1=null;
				                        	  EmployeeBO bo=null;
				                        	  listBO1=new ArrayList();
				                        	  while(rs.next()){
				                        		 bo=new EmployeeBO();
				                        		 bo.setEno(rs.getInt(1));
				                        		 bo.setEname(rs.getString(2));
				                        		 bo.setDesg(rs.getString(3));
				                        		 bo.setSalary(rs.getInt(4));
				                        		 listBO1.add(bo);
				                        	  }//while
				                        	  return listBO1;
				                          });
		return listBO;
	}//method
	
	@Override
	public int insert(EmployeeBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count=0;
		//prepare Parameters using SqlParameterSource
		bpsps=new BeanPropertySqlParameterSource(bo);
		count=npjt.update(INSERT_EMP, bpsps);
		return count;
	}

}//class
