package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
   public List<EmployeeBO>  getEmpsByEnoRange(int start,int end);
   public  EmployeeBO   getEmpByEno(int no);
   public  int updateSalaryByDesg(String desg);
}
