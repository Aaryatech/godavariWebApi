package com.ats.godaapi.repository.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.dashreport.CatwiseOrderQty;

public interface CatwiseOrderQtyByDateRepo extends JpaRepository<CatwiseOrderQty, Integer>{
	

	@Query(value = "SELECT  SUM(t_order_detail.order_qty) as order_qty , m_item.cat_id ,  m_category.cat_eng_name FROM m_item,m_category,"
			+ " t_order_header LEFT JOIN t_order_detail ON t_order_header.order_header_id= t_order_detail.order_header_id"
			+ " WHERE t_order_header.dist_id IN (SELECT m_dist.dist_id FROM m_dist WHERE m_dist.hub_id =:hubId) AND "
			+ "t_order_header.order_date =:date "
			+ "AND m_item.item_id=t_order_detail.item_id AND m_category.cat_id=m_item.cat_id GROUP BY m_item.cat_id", nativeQuery = true)
	List<CatwiseOrderQty> getCatOrderQtyByDate(@Param("date") String date, @Param("hubId") int hubId);

	
	@Query(value = "SELECT SUM(t_order_detail.order_qty) as order_qty , m_item.cat_id , "
			+ "m_category.cat_eng_name FROM m_item,m_category, t_order_header LEFT JOIN "
			+ "t_order_detail ON t_order_header.order_header_id= t_order_detail.order_header_id "
			+ "WHERE t_order_header.order_date =:date AND m_item.item_id=t_order_detail.item_id "
			+ "AND m_category.cat_id=m_item.cat_id GROUP BY m_item.cat_id", nativeQuery = true)
	List<CatwiseOrderQty> getCatOrderQtyByDateForMs(@Param("date") String date);


}
