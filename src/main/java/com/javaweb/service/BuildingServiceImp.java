package com.javaweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepositoy;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.rentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.rentAreaEntity;
@Service
public class BuildingServiceImp implements BuildingService{
	@Autowired
	private BuildingRepositoy buildingRepositoy;
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private rentAreaRepository rentAreaRepository;
	@Override
	public List<BuildingDTO> findAll(Map<String, Object> param, List<String> typeCode) {
		List<BuildingEntity> buildingEntities = buildingRepositoy.findAll(param, typeCode);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			DistrictEntity districtEntity = districtRepository.findNameById(item.getDistrictId());
			rentAreaEntity rentAreaEntity = rentAreaRepository.findValue(item.getRentAreaFrom(), item.getRentAreaTo());
			buildingDTO.setName(item.getName());
			buildingDTO.setAdress(districtEntity.getName() + " " + item.getWard() + " "  + item.getStreet());
			buildingDTO.setManagerName(item.getManagerName());
			buildingDTO.setPhoneManagerNumber(item.getPhoneManagerNumber());
			buildingDTO.setFloorArea(item.getFloorArea());
			buildingDTO.setRentPrice(item.getRentPrice());
			buildingDTO.setBrokeragefee(item.getBrokeragefee());
			buildingDTO.setServiceFee(item.getServiceFee());
			buildingDTO.setRentArea(rentAreaEntity.getValue());
			result.add(buildingDTO);
		}
		return result;
	}

}
