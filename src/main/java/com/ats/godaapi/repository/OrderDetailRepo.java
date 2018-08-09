package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.godaapi.model.OrderDetail;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {

	List<OrderDetail> findByOrderHeaderId(int orderHeaderId);

}
