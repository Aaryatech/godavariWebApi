package com.ats.godaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "route_id")
	private int routeId;

	private int routeSeqNo;
	private int hubId;
	private String routeEngName;
	private String routeMarName;

	private int isUsed;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getRouteSeqNo() {
		return routeSeqNo;
	}

	public void setRouteSeqNo(int routeSeqNo) {
		this.routeSeqNo = routeSeqNo;
	}

	public int getHubId() {
		return hubId;
	}

	public void setHubId(int hubId) {
		this.hubId = hubId;
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

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeSeqNo=" + routeSeqNo + ", hubId=" + hubId + ", routeEngName="
				+ routeEngName + ", routeMarName=" + routeMarName + ", isUsed=" + isUsed + "]";
	}

}
