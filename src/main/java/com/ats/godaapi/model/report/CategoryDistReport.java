package com.ats.godaapi.model.report;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryDistReport {

	
	@Id
	private int catId;
	
	private String catEngName;
	private String catMarName;
	
	

	private int orderQty;

	private float itemTotal;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatEngName() {
		return catEngName;
	}

	public void setCatEngName(String catEngName) {
		this.catEngName = catEngName;
	}

	public String getCatMarName() {
		return catMarName;
	}

	public void setCatMarName(String catMarName) {
		this.catMarName = catMarName;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public float getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(float itemTotal) {
		this.itemTotal = itemTotal;
	}

	@Override
	public String toString() {
		return "CategoryDistReport [catId=" + catId + ", catEngName=" + catEngName + ", catMarName=" + catMarName
				+ ", orderQty=" + orderQty + ", itemTotal=" + itemTotal + "]";
	}

	

	
}
