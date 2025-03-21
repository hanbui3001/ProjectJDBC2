package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.rentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.rentAreaEntity;
@Repository
public class rentAreaRepositoryImp implements rentAreaRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "300105";
	@Override
	public rentAreaEntity findValue(Long from, Long to) {
		StringBuilder sql = new StringBuilder("select value from rentarea where 1=1 ");
		if(from != null) {
			sql.append(" AND value >=" + from + ";");
		}
		if(to != null) {
			sql.append(" and value <= "+ to + ";");
		}
		rentAreaEntity rentAreaEntity = new rentAreaEntity();
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
	    		java.sql.Statement statement = connection.createStatement();
	    		ResultSet rs = statement.executeQuery(sql.toString());){
	    			while(rs.next()){
	    				rentAreaEntity.setValue(rs.getLong("value"));
	    			}
	    		
	    	} catch (Exception e) {
				e.printStackTrace();
			}
		    
			return rentAreaEntity;
	}
	
}
