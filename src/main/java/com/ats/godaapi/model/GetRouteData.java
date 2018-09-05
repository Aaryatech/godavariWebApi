package com.ats.godaapi.model;

import java.util.List;

import javax.persistence.Transient;

public class GetRouteData {

	private Route route;

	@Transient
	List<GetOrderRoute> getOrderList;

	private boolean error;
	private String msg;

	private int detailId;

	private int headerId;
	private int supervisorId;
	private String dayStartTime;
	private String dayEndTime;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<GetOrderRoute> getGetOrderList() {
		return getOrderList;
	}

	public void setGetOrderList(List<GetOrderRoute> getOrderList) {
		this.getOrderList = getOrderList;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getHeaderId() {
		return headerId;
	}

	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getDayStartTime() {
		return dayStartTime;
	}

	public void setDayStartTime(String dayStartTime) {
		this.dayStartTime = dayStartTime;
	}

	public String getDayEndTime() {
		return dayEndTime;
	}

	public void setDayEndTime(String dayEndTime) {
		this.dayEndTime = dayEndTime;
	}

	@Override
	public String toString() {
		return "GetRouteData [route=" + route + ", getOrderList=" + getOrderList + ", error=" + error + ", msg=" + msg
				+ ", detailId=" + detailId + ", headerId=" + headerId + ", supervisorId=" + supervisorId
				+ ", dayStartTime=" + dayStartTime + ", dayEndTime=" + dayEndTime + "]";
	}

}
