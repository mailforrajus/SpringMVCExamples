package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.EmployeeBO;
//@Repository("empDAO")
@Named("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPs_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String GET_Emps_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB=?";
	//@Autowired
	@Resource
	private JdbcTemplate jt;

	



	/*@Override
	public EmployeeBO getEmployeeDetailsByNo(int no) {
		 EmployeeBO bo=null;
		 bo=jt.queryForObject(GET_EMPs_BY_NO, new RowMapper<EmployeeBO>(){
			   @Override
			public EmployeeBO mapRow(ResultSet rs, int index) throws SQLException {
				   EmployeeBO bo=null;
					  //copy ResultSet obj record to BO class obj
					  bo=new EmployeeBO();
					  bo.setEid(rs.getInt(1));
					  bo.setEname(rs.getString(2));
					  bo.setDesg(rs.getString(3));
					  bo.setSalary(rs.getInt(4));
					  bo.setDeptNo(rs.getInt(5));
				return bo;
			}
		 }//anynomous inner classs
		 , no);
		return bo;
	}
*/	
	
	public EmployeeBO getEmployeeDetailsByNo(int no) {
		 EmployeeBO bo=null;
		 bo=jt.queryForObject(GET_EMPs_BY_NO, (rs,index)->{
			  EmployeeBO bo1=null;
			  //copy ResultSet obj record to BO class obj
			  bo1=new EmployeeBO();
			  bo1.setEid(rs.getInt(1));
			  bo1.setEname(rs.getString(2));
			  bo1.setDesg(rs.getString(3));
			  bo1.setSalary(rs.getInt(4));
			  bo1.setDeptNo(rs.getInt(5));
			return bo1;
		 }, no);
		return bo;
	}
	
	@Override
	public List<EmployeeBO> getEmployeeDetailsByDesg(String desg) {
	   List<EmployeeBO> listBO=null;
	   listBO=jt.query(GET_Emps_BY_DESG,
			                        new ResultSetExtractor<List<EmployeeBO>>(){

										@Override
										public List<EmployeeBO> extractData(ResultSet rs)
												throws SQLException, DataAccessException {
											List<EmployeeBO> listBO=null;
											listBO=new ArrayList();
											EmployeeBO bo=null;
											while(rs.next()){
												bo=new EmployeeBO();
												bo.setEid(rs.getInt(1));
												bo.setEname(rs.getString(2));
												bo.setDesg(rs.getString(3));
												bo.setSalary(rs.getInt(4));
												bo.setDeptNo(rs.getInt(5));
												listBO.add(bo);
											}//while
											return listBO;
										}//extractData(-)
	   } ,
      desg);			   
		return listBO;
	}
	
	/*private class EmpRowMapper implements RowMapper<EmployeeBO>{

		@Override
		public EmployeeBO mapRow(ResultSet rs, int index) throws SQLException {
			  EmployeeBO bo=null;
			  //copy ResultSet obj record to BO class obj
			  bo=new EmployeeBO();
			  bo.setEid(rs.getInt(1));
			  bo.setEname(rs.getString(2));
			  bo.setDesg(rs.getString(3));
			  bo.setSalary(rs.getInt(4));
			  bo.setDeptNo(rs.getInt(5));
			return bo;
		}
		
	}*/

}
