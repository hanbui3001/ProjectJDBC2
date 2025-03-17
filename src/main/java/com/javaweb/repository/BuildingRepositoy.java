package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepositoy {
	List<BuildingEntity> findAll(String name, Long district);
}
