package com.ats.godaapi.model.dashreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CatwiseOrderQty {

	@Id
	private int catId;
	private int orderQty;
	private String catEngName;
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public String getCatEngName() {
		return catEngName;
	}
	public void setCatEngName(String catEngName) {
		this.catEngName = catEngName;
	}
	
	@Override
	public String toString() {
		return "CatwiseOrderQty [catId=" + catId + ", orderQty=" + orderQty + ", catEngName=" + catEngName + "]";
	}
	
	

	
}
