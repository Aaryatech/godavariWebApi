package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.godaapi.model.GetRoute;

public interface GetRouteRepo extends JpaRepository<GetRoute, Integer> {

	@Query(value = "SELECT r.*,h.hub_eng_name,h.hub_mar_name,h.hub_eng_add,h.hub_mar_add FROM m_route r ,m_hub h  WHERE r.is_used=1 AND r.hub_id=h.hub_id", nativeQuery = true)
	List<GetRoute> getRouteHubName();

}
