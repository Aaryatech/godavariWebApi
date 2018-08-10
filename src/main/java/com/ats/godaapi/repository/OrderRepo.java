package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.godaapi.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

	Order findByOrderHeaderId(int orderHeaderId);

	List<Order> findByDistId(int distId);

	List<Order> findByOrderDate(String orderDate);

}
