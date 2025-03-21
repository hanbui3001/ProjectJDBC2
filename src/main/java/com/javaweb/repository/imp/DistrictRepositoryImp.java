package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
@Repository
public class DistrictRepositoryImp implements DistrictRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "300105";
	@Override
	public DistrictEntity findNameById(Long id) {
		StringBuilder sql = new StringBuilder("select d.name from district d where d.id =" + id + ";");
		DistrictEntity districtEntity = new DistrictEntity();
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
	    		java.sql.Statement statement = connection.createStatement();
	    		ResultSet rs = statement.executeQuery(sql.toString());){
	    			while(rs.next()){
	    				districtEntity.setName(rs.getString("d.name"));
	    			}
	    		
	    	} catch (Exception e) {
				e.printStackTrace();
			}
		    
			return districtEntity;
	}

}
