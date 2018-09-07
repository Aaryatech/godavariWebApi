package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetOrderHub;

public interface GetOrderHubRepo extends JpaRepository<GetOrderHub, Integer> {

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no FROM t_order_header h,m_dist d WHERE  d.dist_id=h.dist_id AND h.order_type=0 AND h.order_status=0 AND h.order_date=:currDate", nativeQuery = true)
	List<GetOrderHub> getOrderHub(@Param("currDate") String currDate);

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no FROM t_order_header h,m_dist d WHERE  d.dist_id=h.dist_id AND  h.order_header_id=:orderHeaderId", nativeQuery = true)
	GetOrderHub getOrderByOrderHeaderId(@Param("orderHeaderId") int orderHeaderId);

}