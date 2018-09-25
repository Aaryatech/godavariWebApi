package com.ats.godaapi.model.dashreport;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AllHubLatestOrder {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hub_id")
	private int hubId;

	private String hubEngName;
	private String hubMarName;
	

	private String hubContactNo;
	
	
	
	private Date orderDate;
	private float orderTotal;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public float getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}
	@Override
	public String toString() {
		return "AllHubLatestOrder [hubId=" + hubId + ", hubEngName=" + hubEngName + ", hubMarName=" + hubMarName
				+ ", hubContactNo=" + hubContactNo + ", orderDate=" + orderDate + ", orderTotal=" + orderTotal + "]";
	}
	

}