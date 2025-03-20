package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepositoy;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.util.NumberUtil;
import com.javaweb.util.StringUtil;
@Repository
public class BuildingRepositoryImp implements BuildingRepositoy{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "300105";
    public static void joinTable(Map<String, Object> param, List<String>typeCode, StringBuilder sql) {
    	String staffId = param.get("staffId").toString();
    	if(StringUtil.checkString(staffId)) {
    		sql.append(" join assignmentbuilding c on b.id = c.build");
    	}	
    	if(typeCode != null && typeCode.size() != 0) {
    		sql.append(" join buildingrenttype on b.id = buildingrenttype.buildingid ");
    		sql.append(" join renttype on renttype.id = buildingrenttype.renttypeid ");
    	}
    	String rentAreaFrom = param.get("areaFrom").toString();
    	String rentAreaTo = param.get("areaTo").toString();
    	if(StringUtil.checkString(rentAreaFrom) || StringUtil.checkString(rentAreaTo)) {
    		sql.append(" join rentarea on b.id = rentarea.buildingid ");
    	}
    }
    public static void queryNormal(Map<String,Object> param, StringBuilder where) {
    	for(Map.Entry<String, Object> it : param.entrySet()) {
    		if(!(it.getKey().equals("staffId") && it.getKey().equals("typeCode") 
    				&& it.getKey().startsWith("area") && it.getKey().startsWith("Price"))) {
    			String value = it.getValue().toString();
    			if(StringUtil.checkString(value)) {
    				if(NumberUtil.checkNumber(value)) {
    					where.append(" AND b." + it.getKey() + " = "  + value);
    				}
    				else {
    					where.append(" and b." + it.getKey() + " like '%" + value + "%' ");
    				}
    			}
    		}
    	}
    }
    public static void querySpecial(Map<String, Object> param, List<String>typeCode, StringBuilder where) {
    	
    }
	@Override
	public List<BuildingEntity> findAll(Map<String,Object> param, List<String>typeCode) {
    	StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.ward, b.street, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphonenumber, b.servicefee, b.brokeragefee  FROM building b ");
    	joinTable(param, typeCode, sql);
    	StringBuilder where = new StringBuilder(" where 1=1 ");
    	List<BuildingEntity> result = new ArrayList<>();
    	System.out.print(sql);
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
