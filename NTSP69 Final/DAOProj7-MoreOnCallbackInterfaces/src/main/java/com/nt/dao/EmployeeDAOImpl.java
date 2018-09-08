package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPs_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String GET_Emps_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB=?";
	private JdbcTemplate jt;

	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}



	
	public EmployeeBO getEmployeeDetailsByNo(int no) {
		 EmployeeBO bo=null;
		 BeanPropertyRowMapper bprm=null;
		 bprm=new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class,true);
		 bo=(EmployeeBO) jt.queryForObject(GET_EMPs_BY_NO,bprm,no);
		return bo;
	}
	
	@Override
	public List<EmployeeBO> getEmployeeDetailsByDesg(String desg) {
	   List<EmployeeBO> listBO=new ArrayList();
	  
	   jt.query(GET_Emps_BY_DESG,
			           new RowCallbackHandler(){
						@Override
						public void processRow(ResultSet rs) throws SQLException {
                           EmployeeBO bo=null;
							System.out.println("processRow(-)");
							bo=new EmployeeBO();
							bo.setEmpNo(rs.getInt(1));
							bo.setEname(rs.getString(2));
							bo.setJob(rs.getString(3));
							bo.setSal(rs.getInt(4));
							bo.setDeptNo(rs.getInt(5));
							listBO.add(bo);
						}//processRow(-)
	   },
		desg);	           
	   return listBO;
	}//method
}//class
