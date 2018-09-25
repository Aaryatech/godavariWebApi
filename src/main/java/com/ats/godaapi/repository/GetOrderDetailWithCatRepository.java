package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.godaapi.model.GetOrderDetailForSupervisor;

public interface GetOrderDetailWithCatRepository extends JpaRepository<GetOrderDetailForSupervisor,Integer>{

	
	
	@Query(value = "SELECT d.order_detail_id, d.order_header_id, d.item_id, d.item_rate, SUM(d.order_qty) as order_qty,"
			+ " SUM(d.hub_qty) as hub_qty,SUM(d.ms_qty) as ms_qty, SUM(d.deliver_qty) as deliver_qty, d.item_total, d.item_cgst , "
			+ "d.item_sgst , d.item_igst, d.item_basic_value,  i.cat_id,i.item_eng_name,i.item_mar_name,i.item_eng_desc,i.item_mar_desc, "
			+ "u.uom_name,i.item_wt FROM t_order_detail d,t_order_header h,m_item i,m_uom u WHERE d.order_header_id=h.order_header_id "
			+ " AND i.item_id=d.item_id AND u.uom_id=i.item_uom_id AND d.order_header_id IN (:orderHeaderId) GROUP BY d.item_id", nativeQuery = true)
	List<GetOrderDetailForSupervisor> getOrderDetail(@Param("orderHeaderId") List<Integer> orderHeaderId);

	
}
