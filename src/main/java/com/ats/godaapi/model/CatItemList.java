package com.ats.godaapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CatItemList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catId;

	private String catEngName;
	private String catMarName;
	private String catPic;
	private int isUsed;

	@Transient
	List<Item> itemList;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatEngName() {
		return catEngName;
	}

	public void setCatEngName(String catEngName) {
		this.catEngName = catEngName;
	}

	public String getCatMarName() {
		return catMarName;
	}

	public void setCatMarName(String catMarName) {
		this.catMarName = catMarName;
	}

	public String getCatPic() {
		return catPic;
	}

	public void setCatPic(String catPic) {
		this.catPic = catPic;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "CatItemList [catId=" + catId + ", catEngName=" + catEngName + ", catMarName=" + catMarName + ", catPic="
				+ catPic + ", isUsed=" + isUsed + ", itemList=" + itemList + "]";
	}

}
