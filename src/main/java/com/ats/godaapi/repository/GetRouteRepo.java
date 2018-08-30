package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetRoute;

public interface GetRouteRepo extends JpaRepository<GetRoute, Integer> {

	@Query(value = "SELECT r.*,h.hub_eng_name,h.hub_mar_name,h.hub_eng_add,h.hub_mar_add FROM m_route r ,m_hub h  WHERE r.is_used=1 AND r.hub_id=h.hub_id", nativeQuery = true)
	List<GetRoute> getRouteHubName();

	@Query(value = "SELECT r.* ,h.hub_eng_name,h.hub_mar_name,h.hub_eng_add,h.hub_mar_add FROM m_route r,m_hub h  WHERE r.route_id NOT IN (SELECT route_id FROM t_route_allocation WHERE  "
			+ " :fromDate BETWEEN t_route_allocation.from_date AND t_route_allocation.to_date AND :toDate BETWEEN "
			+ "t_route_allocation.from_date AND t_route_allocation.to_date  ) AND r.is_used=1 AND r.hub_id=h.hub_id", nativeQuery = true)
	List<GetRoute> getRouteBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
