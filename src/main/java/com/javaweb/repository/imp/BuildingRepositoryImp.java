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
    	String staffId = (String)param.get("staffId");
    	if(StringUtil.checkString(staffId)) {
    		sql.append(" join assignmentbuilding c on b.id = c.buildingid");
    	}	
    	if(typeCode != null && typeCode.size() != 0) {
    		sql.append(" join buildingrenttype on b.id = buildingrenttype.buildingid ");
    		sql.append(" join renttype on renttype.id = buildingrenttype.renttypeid ");
    	}
    	String rentAreaFrom = (String)param.get("areaFrom");
    	String rentAreaTo = (String)param.get("areaTo");
    	if(StringUtil.checkString(rentAreaFrom) || StringUtil.checkString(rentAreaTo)) {
    		sql.append(" join rentarea on b.id = rentarea.buildingid ");
    	}
    }
    public static void queryNormal(Map<String,Object> param, StringBuilder where) {
    	for(Map.Entry<String, Object> it : param.entrySet()) {
    		if(!it.getKey().equals("staffId") && !it.getKey().equals("typeCode") 
    				&& !it.getKey().startsWith("area") && !it.getKey().startsWith("Price")) {
    			String value = (String)it.getValue();
    			if(StringUtil.checkString(value)) {
    				if(NumberUtil.checkNumber(value)) {
    					where.append(" AND b." + it.getKey() + " = "  + value);
    				}
    				else if(StringUtil.checkString(value)){
    					where.append(" and b." + it.getKey() + " like '%" + value + "%' ");
    				}
    			}
    		}
    	}
    }
    public static void querySpecial(Map<String, Object> param, List<String>typeCode, StringBuilder where) {
    	String staffId = (String)param.get("staffId");
    	if(StringUtil.checkString(staffId)) {
    		if(NumberUtil.checkNumber(staffId)) {
    			where.append(" and c.staffid = " + staffId);
    		}
    		else {
    			where.append(" and c.staffid like '%" + staffId + "%'");
    		}
    	}
    	if(typeCode != null && !typeCode.isEmpty()) {
    		List<String> result = new ArrayList<>();
    		for(String it : typeCode) {
    			result.add("'" + it + "'");
    		}
    		where.append(" and renttype.code in(" + String.join(",", result) + ")");
    	}
    	String rentAreaFrom = (String)param.get("areaFrom");
    	String rentAreaTo = (String)param.get("areaTo");
    	if(StringUtil.checkString(rentAreaFrom) || StringUtil.checkString(rentAreaTo)) {
    		if(NumberUtil.checkNumber(rentAreaFrom)) {
    			where.append(" and rentarea.value>=" + rentAreaFrom);
    		}
    		if(NumberUtil.checkNumber(rentAreaTo)){
    			where.append(" and rentarea.value<=" + rentAreaTo);
    		}
    	}
    	String PriceFrom = (String)param.get("rentPriceFrom");
    	String PriceTo = (String)param.get("rentPriceTo");
    	if(StringUtil.checkString(PriceFrom) || StringUtil.checkString(PriceTo)) {
    		if(NumberUtil.checkNumber(PriceFrom)) {
    			where.append(" and b.rentprice>=" + PriceFrom);
    		}
    		if(NumberUtil.checkNumber(PriceTo)){
    			where.append(" and b.rentprice<=" + PriceTo);
    		}
    	}
    }
	@Override
	public List<BuildingEntity> findAll(Map<String,Object> param, List<String>typeCode) {
    	StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.districtid, b.ward, b.street, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphonenumber, b.servicefee, b.brokeragefee  FROM building b ");
    	joinTable(param, typeCode, sql);
    	StringBuilder where = new StringBuilder(" where 1=1 ");
    	queryNormal(param, where);
    	querySpecial(param, typeCode, where);
    	where.append(" group by b.id;");
    	sql.append(where);
    	List<BuildingEntity> result = new ArrayList<>();
    	System.out.print(sql);
    	try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
    		java.sql.Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery(sql.toString());){
    			while(rs.next()){
    				BuildingEntity building = new BuildingEntity();
    				building.setId(rs.getLong("b.id"));
    				building.setName(rs.getString("b.name"));
    				building.setWard(rs.getString("b.ward"));
    				building.setStreet(rs.getString("b.street"));
    				building.setNumberOfBasement(rs.getInt("b.numberofbasement"));
    				building.setDistrictId(rs.getLong("b.districtid"));
    				building.setFloorArea(rs.getLong("b.floorarea"));
    				building.setRentPrice(rs.getLong("b.rentprice"));
    				building.setBrokeragefee(rs.getString("b.brokeragefee"));
    				building.setManagerName(rs.getString("b.managername"));
    				building.setPhoneManagerNumber(rs.getString("b.managerphonenumber"));
    				result.add(building);
    			}
    		
    	} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return result;
	    }
	}
