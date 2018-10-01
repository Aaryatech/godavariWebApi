package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetOrderDetail;

public interface GetOrderDetailRepo extends JpaRepository<GetOrderDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_eng_name,i.item_mar_name,i.item_eng_desc,i.item_mar_desc,u.uom_name ,i.item_wt FROM t_order_detail d ,m_item i,m_uom u WHERE d.item_id=i.item_id and d.order_header_id=:orderHeaderId AND u.uom_id=i.item_uom_id", nativeQuery = true)
	List<GetOrderDetail> getOrderDetailHistory(@Param("orderHeaderId") int orderHeaderId);

	@Query(value = "SELECT d.order_detail_id,d.order_header_id,d.item_id,d.item_rate,SUM(d.order_qty) AS order_qty,d.hub_qty,"
			+ "d.ms_qty,SUM(d.item_total) AS item_total,d.deliver_qty,d.item_cgst,d.item_sgst,d.item_igst,d.item_basic_value,"
			+ "i.item_eng_name,i.item_mar_name,i.item_eng_desc,i.item_mar_desc,u.uom_name,i.item_wt FROM t_order_detail d ,m_item i,m_uom u "
			+ "WHERE d.item_id=i.item_id and d.order_header_id=:orderHeaderId AND u.uom_id=i.item_uom_id GROUP BY d.item_id", nativeQuery = true)
	List<GetOrderDetail> getOrderDetailByItemwise(@Param("orderHeaderId") int orderHeaderId);

	@Query(value = "SELECT d.*,i.item_eng_name,i.item_mar_name,i.item_eng_desc,i.item_mar_desc,u.uom_name,i.item_wt FROM t_order_detail d,t_order_header h,m_item i,m_uom u WHERE d.order_header_id=h.order_header_id  AND h.order_date=:orderDate AND h.dist_id=:distId AND i.item_id=d.item_id AND u.uom_id=i.item_uom_id", nativeQuery = true)
	List<GetOrderDetail> getDistwiseOrderDetail(@Param("distId") int distId, @Param("orderDate") String orderDate);

	@Query(value = "SELECT d.*,i.item_eng_name,i.item_mar_name,i.item_eng_desc,i.item_mar_desc,u.uom_name,i.item_wt FROM t_order_detail d,t_order_header h,m_item i,m_uom u WHERE d.order_header_id=h.order_header_id  AND i.item_id=d.item_id AND u.uom_id=i.item_uom_id AND d.order_header_id=:orderHeaderId order by d.order_detail_id desc", nativeQuery = true)
	List<GetOrderDetail> getOrderDetail(@Param("orderHeaderId") int orderHeaderId);

}
