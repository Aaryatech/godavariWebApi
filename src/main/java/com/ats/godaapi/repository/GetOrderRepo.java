package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetOrder;

public interface GetOrderRepo extends JpaRepository<GetOrder, Integer> {

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,s.sup_eng_name,s.sup_mar_name FROM t_order_header h,m_dist d,m_route_supervisor s WHERE h.order_date=:orderDate AND d.dist_id=h.dist_id AND s.sup_id=h.sup_id", nativeQuery = true)
	List<GetOrder> getOrderHeaderlHistory(@Param("orderDate") String orderDate);

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,s.sup_eng_name,s.sup_mar_name FROM t_order_header h,m_dist d,m_route_supervisor s WHERE h.order_date=:orderDate AND d.dist_id=h.dist_id AND s.sup_id=h.sup_id", nativeQuery = true)
	List<GetOrder> getOrderItemwise(@Param("orderDate") String date);

}