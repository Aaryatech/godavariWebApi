package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.godaapi.model.GetItemName;

public interface GetItemNameRepo extends JpaRepository<GetItemName, Integer> {

	@Query(value = "SELECT i.*,c.cat_eng_name,c.cat_mar_name,h.item_hsn_code,u.uom_name  FROM m_item i,m_category c ,m_item_hsn h,m_uom u WHERE i.is_used=1 AND i.cat_id=c.cat_id AND i.item_hsn_id=h.item_hsn_id AND u.uom_id=i.item_uom_id order by i.item_id desc", nativeQuery = true)
	List<GetItemName> getItemName();

}
