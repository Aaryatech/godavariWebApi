package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.ItemwiseOrder;

public interface ItemwiseOrderRepo extends JpaRepository<ItemwiseOrder, Integer> {

	@Query(value = "SELECT SUM(d.order_qty) AS order_qty,SUM(d.item_total) AS item_total,i.* FROM t_order_detail d ,m_item i,t_order_header h WHERE d.item_id=i.item_id AND h.order_date=:orderDate AND h.order_header_id=d.order_header_id  GROUP BY d.item_id ", nativeQuery = true)
	List<ItemwiseOrder> getItemwiseOrder(@Param("orderDate") String orderDate);

}
