package com.ats.godaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_reports_data")
public class ReportData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "data_id")
	private int dataId;

	@Column(name = "ms_name_eng")
	private String msNameEng;

	@Column(name = "ms_name_mar")
	private String msNameMar;

	@Column(name = "ms_logo")
	private String msLogo;

	@Column(name = "ms_add_line1_eng")
	private String msAddLine1Eng;

	@Column(name = "ms_add_line1_mar")
	private String msAddLine1Mar;

	@Column(name = "ms_add_line2_eng")
	private String msAddLine2Eng;

	@Column(name = "ms_add_line2_mar")
	private String msAddLine2Mar;

	@Column(name = "ms_add_line3_eng")
	private String msAddLine3Eng;

	@Column(name = "ms_add_line3_mar")
	private String msAddLine3Mar;

	@Column(name = "ms_fssai_no")
	private String msFssaiNo;

	@Column(name = "ms_gst_no")
	private String msGstNo;

	public int getDataId() {
		return dataId;
	}

	public void setDataId(int dataId) {
		this.dataId = dataId;
	}

	public String getMsNameEng() {
		return msNameEng;
	}

	public void setMsNameEng(String msNameEng) {
		this.msNameEng = msNameEng;
	}

	public String getMsNameMar() {
		return msNameMar;
	}

	public void setMsNameMar(String msNameMar) {
		this.msNameMar = msNameMar;
	}

	public String getMsLogo() {
		return msLogo;
	}

	public void setMsLogo(String msLogo) {
		this.msLogo = msLogo;
	}

	public String getMsAddLine1Eng() {
		return msAddLine1Eng;
	}

	public void setMsAddLine1Eng(String msAddLine1Eng) {
		this.msAddLine1Eng = msAddLine1Eng;
	}

	public String getMsAddLine1Mar() {
		return msAddLine1Mar;
	}

	public void setMsAddLine1Mar(String msAddLine1Mar) {
		this.msAddLine1Mar = msAddLine1Mar;
	}

	public String getMsAddLine2Eng() {
		return msAddLine2Eng;
	}

	public void setMsAddLine2Eng(String msAddLine2Eng) {
		this.msAddLine2Eng = msAddLine2Eng;
	}

	public String getMsAddLine2Mar() {
		return msAddLine2Mar;
	}

	public void setMsAddLine2Mar(String msAddLine2Mar) {
		this.msAddLine2Mar = msAddLine2Mar;
	}

	public String getMsAddLine3Eng() {
		return msAddLine3Eng;
	}

	public void setMsAddLine3Eng(String msAddLine3Eng) {
		this.msAddLine3Eng = msAddLine3Eng;
	}

	public String getMsAddLine3Mar() {
		return msAddLine3Mar;
	}

	public void setMsAddLine3Mar(String msAddLine3Mar) {
		this.msAddLine3Mar = msAddLine3Mar;
	}

	public String getMsFssaiNo() {
		return msFssaiNo;
	}

	public void setMsFssaiNo(String msFssaiNo) {
		this.msFssaiNo = msFssaiNo;
	}

	public String getMsGstNo() {
		return msGstNo;
	}

	public void setMsGstNo(String msGstNo) {
		this.msGstNo = msGstNo;
	}

	@Override
	public String toString() {
		return "ReportData [dataId=" + dataId + ", msNameEng=" + msNameEng + ", msNameMar=" + msNameMar + ", msLogo="
				+ msLogo + ", msAddLine1Eng=" + msAddLine1Eng + ", msAddLine1Mar=" + msAddLine1Mar + ", msAddLine2Eng="
				+ msAddLine2Eng + ", msAddLine2Mar=" + msAddLine2Mar + ", msAddLine3Eng=" + msAddLine3Eng
				+ ", msAddLine3Mar=" + msAddLine3Mar + ", msFssaiNo=" + msFssaiNo + ", msGstNo=" + msGstNo + "]";
	}

}
