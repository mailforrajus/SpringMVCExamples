package com.nt.dao;

import java.util.List;

import com.nt.bo.PassengerDetailsBO;

public interface PassengerDAO {
   public  int[] insert(List<PassengerDetailsBO> listBO);
   
}
