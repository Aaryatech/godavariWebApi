package com.ats.godaapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class DatewiseRoute {
	@Id
	private String currDate;

	@Transient
	List<RouteAllocationWithName> routeAllocationList;

	public String getCurrDate() {
		return currDate;
	}

	public void setCurrDate(String currDate) {
		this.currDate = currDate;
	}

	public List<RouteAllocationWithName> getRouteAllocationList() {
		return routeAllocationList;
	}

	public void setRouteAllocationList(List<RouteAllocationWithName> routeAllocationList) {
		this.routeAllocationList = routeAllocationList;
	}

	@Override
	public String toString() {
		return "DatewiseRoute [currDate=" + currDate + ", routeAllocationList=" + routeAllocationList + "]";
	}

}
