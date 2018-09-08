package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
  @Autowired
	private EmployeeDAO dao;
  
	@Override
	public int register(EmployeeDTO dto) {
		Employee emp=null;
		//convert DTO to Entiy
		emp=new Employee();
		BeanUtils.copyProperties(dto,emp);
		//save object
		 emp=dao.save(emp);
		return emp.getEid();
	}
	
	@Override
		public List<EmployeeDTO> fetchAllEmps() {
			List<Employee> listEmps=null;
			List<EmployeeDTO>  listDTO=new ArrayList();
			//use DAO
			listEmps=(List<Employee>) dao.findAll();
			//convert listEmps to listDTO
			listEmps.forEach(emp->{
				 EmployeeDTO dto=new EmployeeDTO();
				 BeanUtils.copyProperties(emp, dto);
				 listDTO.add(dto);
			});
			return listDTO;
		}//method
	
	@Override
		public EmployeeDTO fetchEmpByEid(int eid) {
		   Employee emp=null;
		   EmployeeDTO dto=null;
		   //get Entity object
		   emp=dao.findOne(eid);
		   //convert Entity to DTO
		   dto=new EmployeeDTO();
		   BeanUtils.copyProperties(emp, dto);
			return dto;
		}
	
	@Override
		public List<EmployeeDTO> fetchEmpsByEmail(String email) {
		List<Employee> listEmps=null;
		List<EmployeeDTO>  listDTO=new ArrayList();
		//use DAO
		listEmps=(List<Employee>) dao.findByEmail(email);
		//convert listEmps to listDTO
		listEmps.forEach(emp->{
			 EmployeeDTO dto=new EmployeeDTO();
			 BeanUtils.copyProperties(emp, dto);
			 listDTO.add(dto);
		});
		return listDTO;
		}
	
	@Override
		public List<EmployeeDTO> fetchEmpsByEidRange(int start, int end) {
		List<Employee> listEmps=null;
		List<EmployeeDTO>  listDTO=new ArrayList();
		//use DAO
		listEmps=(List<Employee>) dao.findBetweenByEnos(start, end);
		//convert listEmps to listDTO
		listEmps.forEach(emp->{
			 EmployeeDTO dto=new EmployeeDTO();
			 BeanUtils.copyProperties(emp, dto);
			 listDTO.add(dto);
		});
		return listDTO;
		}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
		public String addBonusToEmp(int eid, int bonus) {
			int  count=0;
			count=dao.updateSalary(eid, bonus);
			if(count==0)
				return "bonus not added";
			else
				return "salary after adding bonus:"+dao.findOne(eid).getSalary();
		}

}//class
