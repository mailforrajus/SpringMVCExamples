package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;



public class AuthenticateDAOImpl implements AuthenticateDAO {
    private SimpleJdbcCall sjc;
    
	public AuthenticateDAOImpl(SimpleJdbcCall sjc) {
		this.sjc = sjc;
	}

	@Override
	public String authenticate(String user, String pwd) {
		Map<String,Object> inParam=null;
		Map<String,Object> outParam=null;
		//set procedure name
		sjc.setProcedureName("P_AUTHENTICATE");
		inParam=new HashMap();
		inParam.put("user", user);
		inParam.put("pass",pwd);
		outParam=sjc.execute(inParam);
		System.out.println(outParam);
		return (String)outParam.get("RESULT");
	}

	
}
