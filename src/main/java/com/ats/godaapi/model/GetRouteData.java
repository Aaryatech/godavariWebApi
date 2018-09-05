package com.ats.godaapi.model;

import java.util.List;

import javax.persistence.Transient;

public class GetRouteData {

	private Route route;

	@Transient
	List<GetOrderRoute> getOrderList;
	
	private boolean error;
	private String msg;
	
	

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

	@Override
	public String toString() {
		return "GetRouteData [route=" + route + ", getOrderList=" + getOrderList + ", error=" + error + ", msg=" + msg
				+ "]";
	}

}
