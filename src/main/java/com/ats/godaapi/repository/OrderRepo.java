package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Config;
import com.ats.godaapi.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

	Order findByOrderHeaderId(int orderHeaderId);

	List<Order> findByDistId(int distId);

	List<Order> findByOrderDate(String orderDate);
	Order findByOrderDateAndDistIdAndOrderType(String orderDate,int distId,int orderType);

	//sac
	@Transactional
	@Modifying
	@Query("UPDATE Order SET orderTotal=:orderTotal WHERE orderHeaderId=:orderHeaderId ")
	int updateOrderTotal(@Param("orderTotal") float orderTotal,@Param("orderHeaderId") int orderHeaderId);
}
