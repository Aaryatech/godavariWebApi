package com.ats.godaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_hub_user")
public class HubUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hs_id")
	private int hsId;

	private int hubId;

	private String hsEngName;
	private String hsMarName;
	private String hsPwd;
	private int isBlock;
	private int isAdmin;
	private int isUsed;

	public int getHsId() {
		return hsId;
	}

	public void setHsId(int hsId) {
		this.hsId = hsId;
	}

	public int getHubId() {
		return hubId;
	}

	public void setHubId(int hubId) {
		this.hubId = hubId;
	}

	public String getHsEngName() {
		return hsEngName;
	}

	public void setHsEngName(String hsEngName) {
		this.hsEngName = hsEngName;
	}

	public String getHsMarName() {
		return hsMarName;
	}

	public void setHsMarName(String hsMarName) {
		this.hsMarName = hsMarName;
	}

	public String getHsPwd() {
		return hsPwd;
	}

	public void setHsPwd(String hsPwd) {
		this.hsPwd = hsPwd;
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
		return "HubUser [hsId=" + hsId + ", hubId=" + hubId + ", hsEngName=" + hsEngName + ", hsMarName=" + hsMarName
				+ ", hsPwd=" + hsPwd + ", isBlock=" + isBlock + ", isAdmin=" + isAdmin + ", isUsed=" + isUsed + "]";
	}

}
