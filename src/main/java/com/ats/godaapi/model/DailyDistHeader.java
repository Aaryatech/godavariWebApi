package com.ats.godaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_daily_dist_header")
public class DailyDistHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "header_id")
	private int headerId;

	private int routeId;
	private String date;

	public int getHeaderId() {
		return headerId;
	}

	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DailyDistHeader [headerId=" + headerId + ", routeId=" + routeId + ", date=" + date + "]";
	}

}
