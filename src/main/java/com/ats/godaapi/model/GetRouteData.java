package com.ats.godaapi.model;

import java.util.List;

import javax.persistence.Transient;

public class GetRouteData {

	private Route route;

	@Transient
	List<GetOrderRoute> getOrderList;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<GetOrderRoute> getGetOrderList() {
		return getOrderList;
	}

	public void setGetOrderList(List<GetOrderRoute> getOrderList) {
		this.getOrderList = getOrderList;
	}

	@Override
	public String toString() {
		return "GetRouteData [route=" + route + ", getOrderList=" + getOrderList + "]";
	}

}
