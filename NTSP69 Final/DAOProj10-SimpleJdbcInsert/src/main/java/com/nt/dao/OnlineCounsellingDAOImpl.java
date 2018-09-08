package com.nt.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.bo.StudentCounsellingInfoBO;

public class OnlineCounsellingDAOImpl implements OnlineCounsellingDAO {
    private SimpleJdbcInsert sji;
    
	public OnlineCounsellingDAOImpl(SimpleJdbcInsert sji) {
		this.sji = sji;
	}

	@Override
	public int insert(StudentCounsellingInfoBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int result=0;
	   //prepare col names and col values as BeanPropertySqlParameterSource class obj
		bpsps=new BeanPropertySqlParameterSource(bo);
		//set table name
		sji.setTableName("Online_Counselling");
		//set col names and values
		result=sji.execute(bpsps);
		return result;
	}

}
