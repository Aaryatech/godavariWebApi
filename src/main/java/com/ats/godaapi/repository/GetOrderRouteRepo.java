package com.ats.godaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetOrderRoute;

public interface GetOrderRouteRepo extends JpaRepository<GetOrderRoute, Integer> {

	@Query(value = "SELECT h.* ,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no,d.dist_pwd,d.hub_id,d.route_id,d. token,d.route_dist_seq_no,d.dist_crates_pending,d.dist_amt_pending,d.dist_crates_limit,d.dist_amt_limit,d.dist_location ,d.is_block ,d.is_used FROM t_order_header h,m_dist d WHERE  h.dist_id=:distId AND h.order_date=:currDate AND h.order_status =2 AND d.is_used=1 AND d.dist_id=h.dist_id", nativeQuery = true)
	GetOrderRoute getOrderRoutebyDistId(@Param("currDate") String currDate, @Param("distId") int distId);

}
