package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.godaapi.model.GetOrderDetailForSupervisor;

public interface GetOrderDetailWithCatRepository extends JpaRepository<GetOrderDetailForSupervisor,Integer>{

	
	
	@Query(value = "SELECT d.*,i.cat_id,i.item_eng_name,i.item_mar_name,i.item_eng_desc,i.item_mar_desc,u.uom_name,i.item_wt FROM t_order_detail d,t_order_header h,m_item i,m_uom u WHERE d.order_header_id=h.order_header_id  AND i.item_id=d.item_id AND u.uom_id=i.item_uom_id AND d.order_header_id=:orderHeaderId", nativeQuery = true)
	List<GetOrderDetailForSupervisor> getOrderDetail(@Param("orderHeaderId") int orderHeaderId);

	
}
