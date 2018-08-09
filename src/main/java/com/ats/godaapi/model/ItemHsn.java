package com.ats.godaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_item_hsn")
public class ItemHsn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_hsn_id")
	private int itemHsnId;

	private String itemHsnCode;

	private float itemCgst;
	private float itemSgst;
	private float itemIgst;

	private int isUsed;

	public int getItemHsnId() {
		return itemHsnId;
	}

	public void setItemHsnId(int itemHsnId) {
		this.itemHsnId = itemHsnId;
	}

	public String getItemHsnCode() {
		return itemHsnCode;
	}

	public void setItemHsnCode(String itemHsnCode) {
		this.itemHsnCode = itemHsnCode;
	}

	public float getItemCgst() {
		return itemCgst;
	}

	public void setItemCgst(float itemCgst) {
		this.itemCgst = itemCgst;
	}

	public float getItemSgst() {
		return itemSgst;
	}

	public void setItemSgst(float itemSgst) {
		this.itemSgst = itemSgst;
	}

	public float getItemIgst() {
		return itemIgst;
	}

	public void setItemIgst(float itemIgst) {
		this.itemIgst = itemIgst;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "ItemHsn [itemHsnId=" + itemHsnId + ", itemHsnCode=" + itemHsnCode + ", itemCgst=" + itemCgst
				+ ", itemSgst=" + itemSgst + ", itemIgst=" + itemIgst + ", isUsed=" + isUsed + "]";
	}

}
