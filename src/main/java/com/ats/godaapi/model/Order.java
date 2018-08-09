package com.ats.godaapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_order_header")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_header_id")
	private int orderHeaderId;

	private int orderType;
	private int distId;
	private String orderDate;
	private String orderProdDate;
	private String orderDeliveryDate;
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

	@Transient
	List<OrderDetail> orderDetailList;

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

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderProdDate() {
		return orderProdDate;
	}

	public void setOrderProdDate(String orderProdDate) {
		this.orderProdDate = orderProdDate;
	}

	public String getOrderDeliveryDate() {
		return orderDeliveryDate;
	}

	public void setOrderDeliveryDate(String orderDeliveryDate) {
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

	
	
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	@Override
	public String toString() {
		return "Order [orderHeaderId=" + orderHeaderId + ", orderType=" + orderType + ", distId=" + distId
				+ ", orderDate=" + orderDate + ", orderProdDate=" + orderProdDate + ", orderDeliveryDate="
				+ orderDeliveryDate + ", orderTotal=" + orderTotal + ", prevPendingCrateBal=" + prevPendingCrateBal
				+ ", prevPendingAmt=" + prevPendingAmt + ", cratesIssued=" + cratesIssued + ", cratesReceived="
				+ cratesReceived + ", amtReceived=" + amtReceived + ", balAmount=" + balAmount + ", supId=" + supId
				+ ", remark=" + remark + ", orderEntryDatetime=" + orderEntryDatetime + ", orderReceivedDatetime="
				+ orderReceivedDatetime + ", orderDeliveryLocation=" + orderDeliveryLocation + ", orderStatus="
				+ orderStatus + ", orderDetailList=" + orderDetailList + "]";
	}

}
