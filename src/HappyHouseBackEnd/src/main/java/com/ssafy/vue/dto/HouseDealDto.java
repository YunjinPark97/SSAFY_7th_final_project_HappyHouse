package com.ssafy.vue.dto;

public class HouseDealDto {
	
	private String dong;
	private int dealyear;
	private int dealmonth;
	private String apartmentname;
	private String dealamount;
	private String area;
	private String floor;
	
	
	
	@Override
	public String toString() {
		return "HouseDealDto [dong=" + dong + ", dealyear=" + dealyear + ", dealmonth=" + dealmonth + ", apartmentname="
				+ apartmentname + ", dealamount=" + dealamount + ", area=" + area + ", floor=" + floor + "]";
	}

	public HouseDealDto(String dong, int dealyear, int dealmonth, String apartmentname, String dealamount, String area,
			String floor) {
		this.dong = dong;
		this.dealyear = dealyear;
		this.dealmonth = dealmonth;
		this.apartmentname = apartmentname;
		this.dealamount = dealamount;
		this.area = area;
		this.floor = floor;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public int getDealyear() {
		return dealyear;
	}

	public void setDealyear(int dealyear) {
		this.dealyear = dealyear;
	}

	public int getDealmonth() {
		return dealmonth;
	}

	public void setDealmonth(int dealmonth) {
		this.dealmonth = dealmonth;
	}

	public String getApartmentname() {
		return apartmentname;
	}

	public void setApartmentname(String apartmentname) {
		this.apartmentname = apartmentname;
	}

	public String getDealamount() {
		return dealamount;
	}

	public void setDealamount(String dealamount) {
		this.dealamount = dealamount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}
	
}
