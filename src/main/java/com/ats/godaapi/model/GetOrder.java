package com.ats.godaapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetOrder {

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
	
	private String supName;
	private String distName;
	

	@Transient
	List<GetOrderDetail> getOrderDetailList;

}
