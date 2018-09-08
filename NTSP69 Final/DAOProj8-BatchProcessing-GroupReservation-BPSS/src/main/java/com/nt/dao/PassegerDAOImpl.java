package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.PassengerDetailsBO;

public class PassegerDAOImpl implements PassengerDAO {
	private static final String  INSERT_RAILWAY_TICKETS="INSERT INTO RAILWAY_TICKETS VALUES(PNR_SEQ.NEXTVAL,?,?,?,?)";
   private JdbcTemplate jt;
   
	public PassegerDAOImpl(JdbcTemplate jt) {
	super();
	this.jt = jt;
}

	@Override
	public int[] insert(List<PassengerDetailsBO> listBO) {
		int result[]=null;
		result=jt.batchUpdate(INSERT_RAILWAY_TICKETS,
				                                 new BatchPreparedStatementSetter() {
													
													@Override
													public void setValues(PreparedStatement ps, int i) throws SQLException {
														System.out.println("setValues(-)");
													   ps.setString(1,listBO.get(i).getName());
													   ps.setString(2,listBO.get(i).getSourcePlace());
													   ps.setString(3,listBO.get(i).getDestPlace());
													   ps.setFloat(4, listBO.get(i).getFare());
													}//setValues(-,-)
													
													@Override
													public int getBatchSize() {
														System.out.println("getBatchSize()");
														return listBO.size();
													}//getBatchSize()
												} );
		return result;
	}//method
	
}//class
