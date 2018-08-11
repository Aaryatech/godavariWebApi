package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetOrderDetail;

public interface GetOrderDetailRepo extends JpaRepository<GetOrderDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_eng_name,i.item_mar_name,i.item_eng_desc,i.item_mar_desc,i.item_uom FROM t_order_detail d ,m_item i WHERE d.item_id=i.item_id and d.order_header_id=:orderHeaderId", nativeQuery = true)
	List<GetOrderDetail> getOrderDetailHistory(@Param("orderHeaderId") int orderHeaderId);

}
