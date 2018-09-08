package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private DataSource ds;

	
	@Override
	public List<EmployeeBO> retrieveEmpsByDesg(String cond) throws Exception {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		List<EmployeeBO> listBO=null;
		EmployeeBO bo=null;
		//get jdbc con object from jdbc con pool using ds object
		con=ds.getConnection();
		//create Statement object
		st=con.createStatement();
		//prepare SQL query
		query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN "+cond+" ORDER BY JOB";
		//send and execute the SQL query
		rs=st.executeQuery(query);
		//copy ResultSet obj records to ListBO
	    listBO=new ArrayList();
	    while(rs.next()){
	    	//copy each Record of rs to BO class object
	    	bo=new EmployeeBO();
	    	bo.setEno(rs.getInt(1));
	    	bo.setEname(rs.getString(2));
	    	bo.setDesg(rs.getString(3));
	    	bo.setSalary(rs.getInt(4));
	    	//add BO class obj to ListCollection
	    	listBO.add(bo);
	    }
	    //close jdbc objs
	    rs.close();
	    st.close();
	    con.close();
		return listBO;
	}//method
}//class
