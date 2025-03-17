package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepositoy;
import com.javaweb.repository.entity.BuildingEntity;
@Repository
public class BuildingRepositoryImp implements BuildingRepositoy{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "300105";
	@Override
	public List<BuildingEntity> findAll(String name, Long district) {
    	StringBuilder sql = new StringBuilder("SELECT * FROM building  where 1 = 1 ");
    	if(name != null && !name.equals("")) {
    		sql.append("AND name like '%" + name + "%' ");
    	}
    	if(district != null) { sql.append("AND districtid = "+ district + " " );}
    	List<BuildingEntity> result = new ArrayList<>();
    	try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
    		java.sql.Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery(sql.toString());){
    			while(rs.next()){
    				BuildingEntity building = new BuildingEntity();
    				building.setName(rs.getString("name"));
    				building.setWard(rs.getString("ward"));
    				building.setStreet(rs.getString("street"));
    				building.setNumberOfBasement(rs.getInt("numberofbasement"));
    				result.add(building);
    			}
    		
    	} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return result;
	    }
	}
