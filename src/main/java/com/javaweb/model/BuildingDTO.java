package com.javaweb.model;

public class BuildingDTO {
	private String name;
	private String managerName;
	private String phoneManagerNumber;
	private String Adress;
	private Long floorArea;
	private Long rentArea;
	private Long rentPrice;
	private String serviceFee;
	private String brokeragefee;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPhoneManagerNumber() {
		return phoneManagerNumber;
	}
	public void setPhoneManagerNumber(String phoneManagerNumber) {
		this.phoneManagerNumber = phoneManagerNumber;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public Long getRentArea() {
		return rentArea;
	}
	public void setRentArea(Long rentArea) {
		this.rentArea = rentArea;
	}
	public Long getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}
	public String getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(String brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	
}
