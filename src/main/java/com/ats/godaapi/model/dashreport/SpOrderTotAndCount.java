package com.ats.godaapi.model.dashreport;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class SpOrderTotAndCount {
	
	@Id
	private float orderCount;
	private float orderTotal;
	

	public float getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(float orderCount) {
		this.orderCount = orderCount;
	}
	public float getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}
	@Override
	public String toString() {
		return "OrderTotAndCount [orderCount=" + orderCount + ", orderTotal="
				+ orderTotal + "]";
	}
	

}
