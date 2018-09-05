package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetOrder;

public interface GetOrderRepo extends JpaRepository<GetOrder, Integer> {

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no,s.sup_eng_name,s.sup_mar_name FROM t_order_header h,m_dist d,m_route_supervisor s WHERE h.order_date=:orderDate AND d.dist_id=h.dist_id AND s.sup_id=h.sup_id", nativeQuery = true)
	List<GetOrder> getOrderHeaderlHistory(@Param("orderDate") String orderDate);

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no,s.sup_eng_name,s.sup_mar_name FROM t_order_header h,m_dist d,m_route_supervisor s WHERE h.order_date=:orderDate AND d.dist_id=h.dist_id AND s.sup_id=h.sup_id", nativeQuery = true)
	List<GetOrder> getOrderItemwise(@Param("orderDate") String date);

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no,s.sup_eng_name,s.sup_mar_name FROM t_order_header h,m_dist d,m_route_supervisor s WHERE h.order_date=:orderDate AND h.dist_id=:distId AND d.dist_id=h.dist_id AND s.sup_id=h.sup_id", nativeQuery = true)
	List<GetOrder> getOrderDist(@Param("orderDate") String date, @Param("distId") int distId);

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no,s.sup_eng_name,s.sup_mar_name FROM t_order_header h,m_dist d,m_route_supervisor s WHERE  d.dist_id=h.dist_id AND s.sup_id=h.sup_id AND h.order_type=0 AND h.order_status=0 AND h.order_date=:currDate", nativeQuery = true)
	List<GetOrder> getOrder(@Param("currDate") String currDate);

	@Query(value = "SELECT h.*,d.dist_eng_name,d.dist_mar_name,d.dist_add_mar,d.dist_add_eng ,d.dist_contact_no,s.sup_eng_name,s.sup_mar_name FROM t_order_header h,m_dist d,m_route_supervisor s WHERE  d.dist_id=h.dist_id AND s.sup_id=h.sup_id AND h.order_header_id=:orderHeaderId", nativeQuery = true)
	GetOrder getOrderByOrderHeaderid(@Param("orderHeaderId") int orderHeaderId);

	// sachin query for showing selected hub wise,status and type order header
	// 03/sep/2018

	@Query(value = "SELECT h.*, d.dist_eng_name, d.dist_mar_name,"
			+ " d.dist_add_mar, d.dist_add_eng , d.dist_contact_no," + "  s.sup_eng_name, s.sup_mar_name   FROM "
			+ " t_order_header h, m_dist d, m_route_supervisor s " + "  WHERE d.hub_id=:hubId and  d.dist_id=h.dist_id "
			+ "  AND s.sup_id=h.sup_id  AND h.order_type IN (:orderType) "
			+ "  AND h.order_status=:orderStatus AND h.order_date=:currDate", nativeQuery = true)
	List<GetOrder> getOrderByHubIdStausAndType(@Param("currDate") String currDate,
			@Param("orderType") List<Integer> orderType, @Param("orderStatus") int orderStatus,
			@Param("hubId") int hubId);

	@Query(value = "SELECT h.*, d.dist_eng_name, d.dist_mar_name,"
			+ " d.dist_add_mar, d.dist_add_eng , d.dist_contact_no," + "  s.sup_eng_name, s.sup_mar_name   FROM "
			+ " t_order_header h, m_dist d, m_route_supervisor s "
			+ "  WHERE d.dist_id=:distId and  d.dist_id=h.dist_id "
			+ "  AND s.sup_id=h.sup_id  AND h.order_type IN (:orderType) "
			+ "  AND h.order_status=:orderStatus AND h.order_date=:currDate", nativeQuery = true)
	List<GetOrder> getOrderByDistIdStausAndType(@Param("currDate") String currDate,
			@Param("orderType") List<Integer> orderType, @Param("orderStatus") int orderStatus,
			@Param("distId") int distId);

}
