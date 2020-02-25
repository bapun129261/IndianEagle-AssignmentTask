package com.app.Beans;

public class User_Address {

	private String district;
	private int roadNo;
	private String state;

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getRoadNo() {
		return roadNo;
	}

	public void setRoadNo(int roadNo) {
		this.roadNo = roadNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User_Address [district=" + district + ", roadNo=" + roadNo + ", state=" + state + "]";
	}

}
