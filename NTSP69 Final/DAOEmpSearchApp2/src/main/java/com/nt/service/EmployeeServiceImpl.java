package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;
	

	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}


	@Override
	public List<Map<String, Object>> fetchEmpDetialsByDesgs(String[] desgs) {
		String cond=null;
		List<Map<String,Object>> list=null;
		//convert desg[] into sql condition
		cond="(";
		for(int i=0;i<desgs.length;++i){
			if(i==desgs.length-1)
				cond=cond+"'"+desgs[i]+"'";
			else 
				cond=cond+"'"+desgs[i]+"',";
		}
		cond=cond+")";
		//use DAO
		list=dao.getEmployeeDetailsByDegs(cond);
		return list;
	}

}
