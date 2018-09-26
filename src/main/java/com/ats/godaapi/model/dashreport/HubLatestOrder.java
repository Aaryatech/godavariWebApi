package com.ats.godaapi.model.dashreport;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class HubLatestOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_header_id")
	private int orderHeaderId;
	
	private int hubId;

	private String hubEngName;
	private String hubMarName;
	

	private String hubContactNo;
	
	private  int orderType;
	
	private Date orderDate;
	
	
	public int getOrderHeaderId() {
		return orderHeaderId;
	}
	public void setOrderHeaderId(int orderHeaderId) {
		this.orderHeaderId = orderHeaderId;
	}

	
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	private float orderTotal;
	
	
	public float getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}
	public int getHubId() {
		return hubId;
	}
	public void setHubId(int hubId) {
		this.hubId = hubId;
	}
	public String getHubEngName() {
		return hubEngName;
	}
	public void setHubEngName(String hubEngName) {
		this.hubEngName = hubEngName;
	}
	public String getHubMarName() {
		return hubMarName;
	}
	public void setHubMarName(String hubMarName) {
		this.hubMarName = hubMarName;
	}
	public String getHubContactNo() {
		return hubContactNo;
	}
	public void setHubContactNo(String hubContactNo) {
		this.hubContactNo = hubContactNo;
	}
	
	@Override
	public String toString() {
		return "HubLatestOrder [orderHeaderId=" + orderHeaderId + ", hubId=" + hubId + ", hubEngName=" + hubEngName
				+ ", hubMarName=" + hubMarName + ", hubContactNo=" + hubContactNo + ", orderType=" + orderType
				+ ", orderDate=" + orderDate + ", orderTotal=" + orderTotal + "]";
	}
	

}
