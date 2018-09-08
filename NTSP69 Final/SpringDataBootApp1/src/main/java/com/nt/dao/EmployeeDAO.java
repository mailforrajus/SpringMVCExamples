package com.nt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Employee;


public interface EmployeeDAO extends CrudRepository<Employee, Integer> {

	  public List<Employee> findByEmail(String email);
	  @Query(value="from Employee where eid>=:min and eid<=:max")
		public List<Employee> findBetweenByEnos(@Param(value = "min") int start,@Param(value="max")int end);
	  
	  @Query(value="update Employee set salary=salary+:bonus where eid=:id")
      @Modifying
	  public int  updateSalary(@Param(value = "id")int eid,@Param(value = "bonus")int bonus);
}
