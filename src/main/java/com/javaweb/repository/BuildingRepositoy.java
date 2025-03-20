package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepositoy {
	List<BuildingEntity> findAll(Map<String, Object> param, List<String>typeCode);
}
