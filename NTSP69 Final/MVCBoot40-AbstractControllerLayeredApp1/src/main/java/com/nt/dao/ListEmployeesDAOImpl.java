package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class ListEmployeesDAOImpl implements ListEmployeesDAO {
	private static final String  GET_ALL_EMPS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
  @Autowired
	private JdbcTemplate jt;

	

	@Override
	public List<EmployeeBO> retriveAllEmployees() {
		List<EmployeeBO> listBO=null;
		listBO=jt.query(GET_ALL_EMPS,new  EmpExtractor());
		
		return listBO;
	}//method
	
	private  class EmpExtractor implements  ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBO=null;
			EmployeeBO bo=null;
			//copy ResultSet obj records to ListBO collection
			listBO=new ArrayList();
			while(rs.next()){
				bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setDesg(rs.getString(3));
				bo.setSalary(rs.getInt(4));
				bo.setDeptNo(rs.getInt(5));
				listBO.add(bo);
			}///while
			return listBO;
		}//extractData
		
	}//inner class

}//class
