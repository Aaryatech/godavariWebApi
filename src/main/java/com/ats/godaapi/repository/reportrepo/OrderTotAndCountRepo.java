package com.ats.godaapi.repository.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.dashreport.OrderTotAndCount;

public interface OrderTotAndCountRepo extends JpaRepository<OrderTotAndCount, Integer>{
	
	@Query(value = " SELECT coalesce(COUNT(t_order_header.order_header_id),0) AS order_count, "
			+ " coalesce(SUM(t_order_header.order_total),0) as order_total FROM t_order_header,m_dist "
			+ " WHERE t_order_header.order_date=:curDate AND t_order_header.order_type=:orderType AND "
			+ " m_dist.dist_id=t_order_header.dist_id AND m_dist.hub_id=:hubId", nativeQuery = true)
	
	OrderTotAndCount getOrderTotAndCount(@Param("curDate") String curDate,@Param("orderType") int orderType,
			@Param("hubId") int hubId);

	
	
	@Query(value = " SELECT coalesce(COUNT(t_order_header.order_header_id),0) AS order_count, "
			+ " coalesce(SUM(t_order_header.order_total),0) as order_total FROM t_order_header,m_dist "
			+ " WHERE t_order_header.order_date=:curDate AND t_order_header.order_type=:orderType AND "
			+ " m_dist.dist_id=t_order_header.dist_id AND m_dist.hub_id=:hubId", nativeQuery = true)
	
	OrderTotAndCount getSpOrderTotAndCount(@Param("curDate") String curDate,@Param("orderType") int orderType,
			@Param("hubId") int hubId);
	
	@Query(value = " SELECT coalesce(COUNT(t_order_header.order_header_id),0) AS order_count, "
			+ " coalesce(SUM(t_order_header.order_total),0) as order_total FROM t_order_header,m_dist "
			+ " WHERE t_order_header.order_date=:curDate AND t_order_header.order_type IN (0,1) AND t_order_header.order_status=0 AND "
			+ " m_dist.dist_id=t_order_header.dist_id AND m_dist.hub_id=:hubId", nativeQuery = true)
	
	OrderTotAndCount getOrderStatusPending(@Param("curDate") String curDate,
			@Param("hubId") int hubId);
	
	
	
	//  web service Dist Data for Dashboard:
	
	@Query(value = " SELECT coalesce(COUNT(t_order_header.order_header_id),0) AS order_count, "
			+ " coalesce(SUM(t_order_header.order_total),0) as order_total FROM t_order_header "
			+ " WHERE t_order_header.order_date=:curDate AND t_order_header.order_type=:orderType ", nativeQuery = true)
	
	OrderTotAndCount getOrderTotAndCountMs(@Param("curDate") String curDate,@Param("orderType") int orderType);
	
	@Query(value = " SELECT coalesce(COUNT(t_order_header.order_header_id),0) AS order_count, "
			+ " coalesce(SUM(t_order_header.order_total),0) as order_total FROM t_order_header "
			+ " WHERE t_order_header.order_date=:curDate AND t_order_header.order_type=:orderType ", nativeQuery = true)
	
	OrderTotAndCount getSpOrderTotAndCountMs(@Param("curDate") String curDate,@Param("orderType") int orderType);
	
	@Query(value = " SELECT coalesce(COUNT(t_order_header.order_header_id),0) AS order_count, "
			+ " coalesce(SUM(t_order_header.order_total),0) as order_total FROM t_order_header  "
			+ " WHERE t_order_header.order_date=:curDate AND  t_order_header.order_status=0 AND t_order_header.order_type IN (0,1) ", nativeQuery = true)
	
	OrderTotAndCount getOrderStatusPendingMs(@Param("curDate") String curDate);
	
	//

}
