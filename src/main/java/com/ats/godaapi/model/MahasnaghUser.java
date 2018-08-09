package com.ats.godaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_item_hsn")
public class MahasnaghUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ms_id")
	private int msId;

	private String hubsId;
	private String msEngName;
	private String msMarName;
	private String msContactNo;
	private String msPwd;
	private int isBlock;
	private int isAdmin;
	private int isUsed;

	public int getMsId() {
		return msId;
	}

	public void setMsId(int msId) {
		this.msId = msId;
	}

	public String getHubsId() {
		return hubsId;
	}

	public void setHubsId(String hubsId) {
		this.hubsId = hubsId;
	}

	public String getMsEngName() {
		return msEngName;
	}

	public void setMsEngName(String msEngName) {
		this.msEngName = msEngName;
	}

	public String getMsMarName() {
		return msMarName;
	}

	public void setMsMarName(String msMarName) {
		this.msMarName = msMarName;
	}

	public String getMsContactNo() {
		return msContactNo;
	}

	public void setMsContactNo(String msContactNo) {
		this.msContactNo = msContactNo;
	}

	public String getMsPwd() {
		return msPwd;
	}

	public void setMsPwd(String msPwd) {
		this.msPwd = msPwd;
	}

	public int getIsBlock() {
		return isBlock;
	}

	public void setIsBlock(int isBlock) {
		this.isBlock = isBlock;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "MahasnaghUser [msId=" + msId + ", hubsId=" + hubsId + ", msEngName=" + msEngName + ", msMarName="
				+ msMarName + ", msContactNo=" + msContactNo + ", msPwd=" + msPwd + ", isBlock=" + isBlock
				+ ", isAdmin=" + isAdmin + ", isUsed=" + isUsed + "]";
	}

}
