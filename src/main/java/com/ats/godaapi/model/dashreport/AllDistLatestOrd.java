package com.ats.godaapi.model.dashreport;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AllDistLatestOrd {
	
	@Id
	private int orderHeaderId;

	private int orderType;
	
	private int distId;
	
	private Date orderDate;
	private float orderTotal;
	
	private String distEngName;
	private String distMarName;

	private String distContactNo;

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
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
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
		return "AllDistLast3Ord [orderHeaderId=" + orderHeaderId + ", orderType=" + orderType + ", distId=" + distId
				+ ", orderDate=" + orderDate + ", orderTotal=" + orderTotal + ", distEngName=" + distEngName
				+ ", distMarName=" + distMarName + ", distContactNo=" + distContactNo + "]";
	}
	
	
	
	
	//
	
	///SELECT h.order_header_id, h.order_type, h.dist_id, h.order_date, h.order_total,m_dist.dist_eng_name,m_dist.dist_mar_name,m_dist.dist_contact_no FROM t_order_header h,m_dist WHERE h.dist_id=2 and m_dist.dist_id=h.dist_id ORDER BY h.order_header_id DESC LIMIT 3

	//

}
