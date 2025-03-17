package com.javaweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepositoy;
import com.javaweb.repository.entity.BuildingEntity;
@Service
public class BuildingServiceImp implements BuildingService{
	@Autowired
	private BuildingRepositoy buildingRepositoy;
	@Override
	public List<BuildingDTO> findAll(String name, Long district) {
		List<BuildingEntity> buildingEntities = buildingRepositoy.findAll(name, district);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setName(item.getName());
			buildingDTO.setWard(item.getWard());
			buildingDTO.setAdress(item.getStreet());
			buildingDTO.setNumberOfBasement(item.getNumberOfBasement());
			result.add(buildingDTO);
		}
		return result;
	}

}
