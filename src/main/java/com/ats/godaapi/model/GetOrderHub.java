package com.ats.godaapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetOrderHub {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_header_id")
	private int orderHeaderId;

	private int orderType;
	private int distId;
	private Date orderDate;
	private Date orderProdDate;
	private Date orderDeliveryDate;
	private float orderTotal;
	private int prevPendingCrateBal;
	private float prevPendingAmt;
	private int cratesIssued;
	private int cratesReceived;
	private float amtReceived;
	private float balAmount;
	private int supId;
	private String remark;
	private String orderEntryDatetime;
	private String orderReceivedDatetime;
	private String orderDeliveryLocation;
	private int orderStatus;

	private String distEngName;
	private String distMarName;
	private String distContactNo;

	@Transient
	List<GetOrderDetail> getOrderDetailList;

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

	public int getDistId() {
		return distId;
	}

	public void setDistId(int distId) {
		this.distId = distId;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderProdDate() {
		return orderProdDate;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderProdDate(Date orderProdDate) {
		this.orderProdDate = orderProdDate;
	}

	public Date getOrderDeliveryDate() {
		return orderDeliveryDate;
	}

	public void setOrderDeliveryDate(Date orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
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

	public float getPrevPendingAmt() {
		return prevPendingAmt;
	}

	public void setPrevPendingAmt(float prevPendingAmt) {
		this.prevPendingAmt = prevPendingAmt;
	}

	public int getCratesIssued() {
		return cratesIssued;
	}

	public void setCratesIssued(int cratesIssued) {
		this.cratesIssued = cratesIssued;
	}

	public int getCratesReceived() {
		return cratesReceived;
	}

	public void setCratesReceived(int cratesReceived) {
		this.cratesReceived = cratesReceived;
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

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrderEntryDatetime() {
		return orderEntryDatetime;
	}

	public void setOrderEntryDatetime(String orderEntryDatetime) {
		this.orderEntryDatetime = orderEntryDatetime;
	}

	public String getOrderReceivedDatetime() {
		return orderReceivedDatetime;
	}

	public void setOrderReceivedDatetime(String orderReceivedDatetime) {
		this.orderReceivedDatetime = orderReceivedDatetime;
	}

	public String getOrderDeliveryLocation() {
		return orderDeliveryLocation;
	}

	public void setOrderDeliveryLocation(String orderDeliveryLocation) {
		this.orderDeliveryLocation = orderDeliveryLocation;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
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

	public List<GetOrderDetail> getGetOrderDetailList() {
		return getOrderDetailList;
	}

	public void setGetOrderDetailList(List<GetOrderDetail> getOrderDetailList) {
		this.getOrderDetailList = getOrderDetailList;
	}

	@Override
	public String toString() {
		return "GetOrderHub [orderHeaderId=" + orderHeaderId + ", orderType=" + orderType + ", distId=" + distId
				+ ", orderDate=" + orderDate + ", orderProdDate=" + orderProdDate + ", orderDeliveryDate="
				+ orderDeliveryDate + ", orderTotal=" + orderTotal + ", prevPendingCrateBal=" + prevPendingCrateBal
				+ ", prevPendingAmt=" + prevPendingAmt + ", cratesIssued=" + cratesIssued + ", cratesReceived="
				+ cratesReceived + ", amtReceived=" + amtReceived + ", balAmount=" + balAmount + ", supId=" + supId
				+ ", remark=" + remark + ", orderEntryDatetime=" + orderEntryDatetime + ", orderReceivedDatetime="
				+ orderReceivedDatetime + ", orderDeliveryLocation=" + orderDeliveryLocation + ", orderStatus="
				+ orderStatus + ", distEngName=" + distEngName + ", distMarName=" + distMarName + ", distContactNo="
				+ distContactNo + ", getOrderDetailList=" + getOrderDetailList + "]";
	}

}
