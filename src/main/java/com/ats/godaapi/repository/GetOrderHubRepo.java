package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetOrderHub;

public interface GetOrderHubRepo extends JpaRepository<GetOrderHub, Integer> {

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no FROM t_order_header h,m_dist d WHERE  d.dist_id=h.dist_id AND h.order_status IN (:orderStatusList) AND h.order_date=:currDate order by h.order_header_id desc", nativeQuery = true)
	List<GetOrderHub> getOrderHub(@Param("currDate") String currDate,
			@Param("orderStatusList") List<Integer> orderStatusList);

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no FROM t_order_header h,m_dist d WHERE  d.dist_id=h.dist_id AND  h.order_header_id=:orderHeaderId ", nativeQuery = true)
	GetOrderHub getOrderByOrderHeaderId(@Param("orderHeaderId") int orderHeaderId);

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no FROM t_order_header h,m_dist d WHERE  d.dist_id=h.dist_id AND h.order_status=0 AND h.order_date=:currDate  order by h.order_header_id desc", nativeQuery = true)
	List<GetOrderHub> getOrderHubByStatus(@Param("currDate") String currDate);

	@Query(value = "SELECT h.*, d.dist_eng_name, d.dist_mar_name, d.dist_add_mar, d.dist_add_eng , d.dist_contact_no FROM t_order_header h, m_dist d WHERE d.hub_id=:hubId and  d.dist_id=h.dist_id  AND h.order_type IN (:orderType) AND h.order_status=:orderStatus AND h.order_date=:currDate order by h.order_header_id desc", nativeQuery = true)
	List<GetOrderHub> getOrderHubByHubIdStausAndType(@Param("currDate") String currDate,
			@Param("orderType") List<Integer> orderType, @Param("orderStatus") int orderStatus,
			@Param("hubId") int hubId);

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no FROM t_order_header h,m_dist d WHERE h.order_date=:orderDate AND h.dist_id=:distId AND d.dist_id=h.dist_id  AND h.order_status=3 ", nativeQuery = true)
	List<GetOrderHub> getOrderDist(@Param("orderDate") String date, @Param("distId") int distId);

}
