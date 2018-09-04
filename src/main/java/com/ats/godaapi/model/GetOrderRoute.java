package com.ats.godaapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetOrderRoute {

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

	private String distEngName;
	private String distMarName;
	private String distAddMar;
	private String distAddEng;
	private String distContactNo;
	private String distPwd;
	private int hubId;
	private int routeId;
	private String token;
	private String routeDistSeqNo;

	private int distCratesPending;
	private float distAmtPending;
	private int distCratesLimit;
	private float distAmtLimit;
	private String distLocation;
	private int isBlock;

	private int isUsed;

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

	public List<GetOrderDetail> getGetOrderDetailList() {
		return getOrderDetailList;
	}

	public void setGetOrderDetailList(List<GetOrderDetail> getOrderDetailList) {
		this.getOrderDetailList = getOrderDetailList;
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

	public String getDistAddMar() {
		return distAddMar;
	}

	public void setDistAddMar(String distAddMar) {
		this.distAddMar = distAddMar;
	}

	public String getDistAddEng() {
		return distAddEng;
	}

	public void setDistAddEng(String distAddEng) {
		this.distAddEng = distAddEng;
	}

	public String getDistContactNo() {
		return distContactNo;
	}

	public void setDistContactNo(String distContactNo) {
		this.distContactNo = distContactNo;
	}

	public String getDistPwd() {
		return distPwd;
	}

	public void setDistPwd(String distPwd) {
		this.distPwd = distPwd;
	}

	public int getHubId() {
		return hubId;
	}

	public void setHubId(int hubId) {
		this.hubId = hubId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRouteDistSeqNo() {
		return routeDistSeqNo;
	}

	public void setRouteDistSeqNo(String routeDistSeqNo) {
		this.routeDistSeqNo = routeDistSeqNo;
	}

	public int getDistCratesPending() {
		return distCratesPending;
	}

	public void setDistCratesPending(int distCratesPending) {
		this.distCratesPending = distCratesPending;
	}

	public float getDistAmtPending() {
		return distAmtPending;
	}

	public void setDistAmtPending(float distAmtPending) {
		this.distAmtPending = distAmtPending;
	}

	public int getDistCratesLimit() {
		return distCratesLimit;
	}

	public void setDistCratesLimit(int distCratesLimit) {
		this.distCratesLimit = distCratesLimit;
	}

	public float getDistAmtLimit() {
		return distAmtLimit;
	}

	public void setDistAmtLimit(float distAmtLimit) {
		this.distAmtLimit = distAmtLimit;
	}

	public String getDistLocation() {
		return distLocation;
	}

	public void setDistLocation(String distLocation) {
		this.distLocation = distLocation;
	}

	public int getIsBlock() {
		return isBlock;
	}

	public void setIsBlock(int isBlock) {
		this.isBlock = isBlock;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "GetOrderRoute [orderHeaderId=" + orderHeaderId + ", orderType=" + orderType + ", distId=" + distId
				+ ", orderDate=" + orderDate + ", orderProdDate=" + orderProdDate + ", orderDeliveryDate="
				+ orderDeliveryDate + ", orderTotal=" + orderTotal + ", prevPendingCrateBal=" + prevPendingCrateBal
				+ ", prevPendingAmt=" + prevPendingAmt + ", cratesIssued=" + cratesIssued + ", cratesReceived="
				+ cratesReceived + ", amtReceived=" + amtReceived + ", balAmount=" + balAmount + ", supId=" + supId
				+ ", remark=" + remark + ", orderEntryDatetime=" + orderEntryDatetime + ", orderReceivedDatetime="
				+ orderReceivedDatetime + ", orderDeliveryLocation=" + orderDeliveryLocation + ", orderStatus="
				+ orderStatus + ", distEngName=" + distEngName + ", distMarName=" + distMarName + ", distAddMar="
				+ distAddMar + ", distAddEng=" + distAddEng + ", distContactNo=" + distContactNo + ", distPwd="
				+ distPwd + ", hubId=" + hubId + ", routeId=" + routeId + ", token=" + token + ", routeDistSeqNo="
				+ routeDistSeqNo + ", distCratesPending=" + distCratesPending + ", distAmtPending=" + distAmtPending
				+ ", distCratesLimit=" + distCratesLimit + ", distAmtLimit=" + distAmtLimit + ", distLocation="
				+ distLocation + ", isBlock=" + isBlock + ", isUsed=" + isUsed + ", getOrderDetailList="
				+ getOrderDetailList + "]";
	}

}
