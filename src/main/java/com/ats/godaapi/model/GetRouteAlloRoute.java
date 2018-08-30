package com.ats.godaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetRouteAlloRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tr_id")
	private int trId;

	private String fromDate;
	private String toDate;
	private int routeId;
	private int vehicleId;
	private int supervisorId;

	private String routeEngName;
	private String routeMarName;

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getRouteEngName() {
		return routeEngName;
	}

	public void setRouteEngName(String routeEngName) {
		this.routeEngName = routeEngName;
	}

	public String getRouteMarName() {
		return routeMarName;
	}

	public void setRouteMarName(String routeMarName) {
		this.routeMarName = routeMarName;
	}

	@Override
	public String toString() {
		return "GetRouteAlloRoute [trId=" + trId + ", fromDate=" + fromDate + ", toDate=" + toDate + ", routeId="
				+ routeId + ", vehicleId=" + vehicleId + ", supervisorId=" + supervisorId + ", routeEngName="
				+ routeEngName + ", routeMarName=" + routeMarName + "]";
	}

}
