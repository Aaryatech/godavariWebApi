package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.OrderDetail;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {

	List<OrderDetail> findByOrderHeaderId(int orderHeaderId);

	List<OrderDetail> findByItemId(int itemId);

	OrderDetail findByItemIdAndOrderHeaderId(int itemId,int orderHeaderId);

	//Sachin
	@Transactional
	@Modifying
	@Query("UPDATE OrderDetail SET msQty=:msQty,itemTotal=:itemTotal WHERE orderDetailId=:orderDetailId ")
	int updateMsQty(@Param("msQty") int msQty,@Param("itemTotal") float itemTotal,@Param("orderDetailId") int orderDetailId);

	//Sachin
	@Transactional
	@Modifying
	@Query("DELETE FROM OrderDetail  WHERE orderDetailId=:orderDetailId ")
	int deleteOrderDetail(@Param("orderDetailId") int orderDetailId);

}
