package com.ats.godaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_uom")
public class Uom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uom_id")
	private int uomId;

	private String uomName;

	private int isUsed;

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomName=" + uomName + ", isUsed=" + isUsed + "]";
	}

}
