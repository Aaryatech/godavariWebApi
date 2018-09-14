package com.ats.godaapi.model.report;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DistReportByDate {
	
	
	@Id
	private int orderHeaderId;
	
	private float orderTotal ;
	
	private int prevPendingCrateBal;
	
	private int cratesReceived  ;
	
	private int  cratesIssued;
	
	private float prevPendingAmt ;
	
	private float amtReceived;
	
	private float balAmount;
	
	private String distEngName;
	private String distMarName;
	
	private String distContactNo;

	public int getOrderHeaderId() {
		return orderHeaderId;
	}

	public void setOrderHeaderId(int orderHeaderId) {
		this.orderHeaderId = orderHeaderId;
	}

	public float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getPrevPendingCrateBal() {
		return prevPendingCrateBal;
	}

	public void setPrevPendingCrateBal(int prevPendingCrateBal) {
		this.prevPendingCrateBal = prevPendingCrateBal;
	}

	public int getCratesReceived() {
		return cratesReceived;
	}

	public void setCratesReceived(int cratesReceived) {
		this.cratesReceived = cratesReceived;
	}

	public int getCratesIssued() {
		return cratesIssued;
	}

	public void setCratesIssued(int cratesIssued) {
		this.cratesIssued = cratesIssued;
	}

	public float getPrevPendingAmt() {
		return prevPendingAmt;
	}

	public void setPrevPendingAmt(float prevPendingAmt) {
		this.prevPendingAmt = prevPendingAmt;
	}

	public float getAmtReceived() {
		return amtReceived;
	}

	public void setAmtReceived(float amtReceived) {
		this.amtReceived = amtReceived;
	}

	public float getBalAmount() {
		return balAmount;
	}

	public void setBalAmount(float balAmount) {
		this.balAmount = balAmount;
	}

	public String getDistEngName() {
		return distEngName;
	}

	public void setDistEngName(String distEngName) {
		this.distEngName = distEngName;
	}

	public String getDistMarName() {
		return distMarName;
	}

	public void setDistMarName(String distMarName) {
		this.distMarName = distMarName;
	}

	public String getDistContactNo() {
		return distContactNo;
	}

	public void setDistContactNo(String distContactNo) {
		this.distContactNo = distContactNo;
	}

	@Override
	public String toString() {
		return "DistReportByDate [orderHeaderId=" + orderHeaderId + ", orderTotal=" + orderTotal
				+ ", prevPendingCrateBal=" + prevPendingCrateBal + ", cratesReceived=" + cratesReceived
				+ ", cratesIssued=" + cratesIssued + ", prevPendingAmt=" + prevPendingAmt + ", amtReceived="
				+ amtReceived + ", balAmount=" + balAmount + ", distEngName=" + distEngName + ", distMarName="
				+ distMarName + ", distContactNo=" + distContactNo + "]";
	}


}
