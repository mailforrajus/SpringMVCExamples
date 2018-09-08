package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPS_BY_RANGE="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO>=? AND EMPNO<=?";
	private static final String GET_EMP_BY_ENO="SELECT EMPNO,ENAME,JOB,SAL FROM  EMP WHERE EMPNO=?";
	private static final String UPDATE_EMPSAL_BY_DESG="UPDATE EMP SET SAL=SAL+(SAL*0.1) WHERE JOB=?";
	private EmployeeSelctorByRange selector1;
	private EmployeeSelectorByEno selector2;
	private EmployeeUpdator updator1;

	public EmployeeDAOImpl(DataSource ds){
		 selector1=new EmployeeSelctorByRange(ds, GET_EMPS_BY_RANGE);
		 selector2=new EmployeeSelectorByEno(ds,GET_EMP_BY_ENO );
		 updator1=new EmployeeUpdator(ds, UPDATE_EMPSAL_BY_DESG);
	}
	
	 //DAO method
	@Override
	public List<EmployeeBO> getEmpsByEnoRange(int start, int end) {
		List<EmployeeBO>listBO=null;
		listBO=selector1.execute(start, end);
		return listBO;
	}
	
	//DAO method
	@Override
	public EmployeeBO getEmpByEno(int no) {
		EmployeeBO bo=null;
		bo=selector2.findObject(no);
		return bo;
	}
	
	//DAO method
	@Override
	public int updateSalaryByDesg(String desg) {
		int count=updator1.update(desg);
		return count;
	}
	
	
	//inner classes as sub classes
	private class EmployeeSelctorByRange extends MappingSqlQuery<EmployeeBO>{

		 public EmployeeSelctorByRange(DataSource ds,String query) {
	
			 super(ds,query);
			 super.declareParameter(new SqlParameter(Types.INTEGER));
			 super.declareParameter(new SqlParameter(Types.INTEGER));
			 super.compile();
		}
		
		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("Innerclass1:: mapRow(-,-)");
			 EmployeeBO bo=null;
			//copy ResultSet record to BO class obj
			 bo=new  EmployeeBO();
			 bo.setEno(rs.getInt(1));
			 bo.setEname(rs.getString(2));
			 bo.setJob(rs.getString(3));
			 bo.setSalary(rs.getInt(4));
			return bo;
		}//method
	}//inner class

	//inner class2
	private class EmployeeSelectorByEno extends MappingSqlQuery<EmployeeBO>{

		public EmployeeSelectorByEno(DataSource ds,String query) {
          super(ds,query);
          super.declareParameter(new SqlParameter(Types.INTEGER));
          super.compile();
		}
		
		@Override
		public EmployeeBO mapRow(ResultSet rs, int index) throws SQLException {
			System.out.println("inner class2:: mapRow(-,-)");
			EmployeeBO bo=null;
			bo=new EmployeeBO();
			bo.setEno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSalary(rs.getInt(4));
			return bo;
		}//mapRow(-,-)
		
	}//inner class

	 //inner class3
	private class  EmployeeUpdator extends SqlUpdate{
		
		public EmployeeUpdator(DataSource ds,String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}
		
	}
	
}//DAO class
