package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPs_COUNT="SELECT COUNT(*) FROM EMP";
	private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String  GET_EMP_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private static final String GET_EMP_NAME_BY_EMPNO="SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String  INSERT_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
    private static final String  UPDATE_SALARY_BY_NO="UPDATE EMP SET SAL=? WHERE EMPNO=? ";
    private static final String  GET_SALARY_BY_NO="SELECT SAL FROM EMP WHERE EMPNO=?";
    private static final String DELETE_EMP_BY_NO="DELETE FROM EMP WHERE EMPNO=?";
	private JdbcTemplate jt;

	public EmployeeDAOImpl(JdbcTemplate jt) {
	
		this.jt = jt;
	}

	@Override
	public int getEmpsRecordCount() {
		int count=0;
		System.out.println("Data source obj class name::"+jt.getDataSource().getClass());
		count=jt.queryForObject(GET_EMPs_COUNT,Integer.class);
		return count;
	}

	@Override
	public Map<String, Object> getEmpRecordById(int empNo) {
     Map<String,Object> map=null;
     map=jt.queryForMap(GET_EMP_BY_NO,empNo);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmpsByDesgs(String desg1, String desg2, String desg3) {
		 List<Map<String,Object>> list=null;
		 list=jt.queryForList(GET_EMP_BY_DESG,desg1,desg2,desg3);
		return list;
	}
	
	@Override
	public String getEmpNameByNo(int empNo) {
	  String name=null;
	  name=jt.queryForObject(GET_EMP_NAME_BY_EMPNO, String.class,empNo);
		return name;
	}

	@Override
	public int insert(int no, String name, String desg, int salary) {
		int count=0;
		count=jt.update(INSERT_EMP,no,name,desg,salary);
		return count;
	}

	@Override
	public int update(int empNo, int newSalary) {
		int count=0;
		count=jt.update(UPDATE_SALARY_BY_NO,newSalary,empNo);
		return count;
	}
	
	@Override
	public int getSalary(int empNo) {
		int salary=0;
		salary=jt.queryForObject(GET_SALARY_BY_NO, Integer.class,empNo);
		return salary;
	}
	
	@Override
	public int delete(int empNo) {
		int count=0;
		//use dAO
		count=jt.update(DELETE_EMP_BY_NO, empNo);
		return count;
	}
	

}
