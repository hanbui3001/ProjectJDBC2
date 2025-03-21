package com.javaweb.repository.entity;

public class BuildingEntity {
	private Long id;
	private String name;
	private int numberOfBasement;
	private String ward;
	private String street;
	private Long districtId;
	private Long floorArea;
	private Long rentPrice;
	private String serviceFee;
	private String brokeragefee;
	private String managerName;
	private String phoneManagerNumber;
	private Long rentAreaFrom;
	private Long rentAreaTo;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(int numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
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
	public Long getRentAreaFrom() {
		return rentAreaFrom;
	}
	public void setRentAreaFrom(Long rentAreaFrom) {
		this.rentAreaFrom = rentAreaFrom;
	}
	public Long getRentAreaTo() {
		return rentAreaTo;
	}
	public void setRentAreaTo(Long rentAreaTo) {
		this.rentAreaTo = rentAreaTo;
	}
	
}
