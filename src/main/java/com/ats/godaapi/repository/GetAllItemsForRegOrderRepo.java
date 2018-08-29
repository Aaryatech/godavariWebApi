package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetAllItemsForRegOrder;


public interface GetAllItemsForRegOrderRepo extends JpaRepository<GetAllItemsForRegOrder,Integer>{
	
	
	@Query(value = "SELECT i.* ,u.uom_name, h.item_cgst,h.item_sgst,h.item_igst FROM m_item i ,m_uom u ,m_item_hsn h WHERE i.item_id IN :itemId AND i.cat_id= :catId AND i.is_used=1 AND i.item_uom_id=u.uom_id AND i.item_hsn_id =h.item_hsn_id", nativeQuery = true)
	List<GetAllItemsForRegOrder> getAllItemDetails(@Param("itemId") List<Integer> itemId,@Param("catId")int catId);
	

}
