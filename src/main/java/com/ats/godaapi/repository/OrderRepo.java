package com.ats.godaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.godaapi.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

	Order findByOrderHeaderId(int orderHeaderId);

}
