package com.ats.godaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.RouteAllocation;

public interface RouteAllocationRepo extends JpaRepository<RouteAllocation, Integer> {

	RouteAllocation findByTrId(int trId);

	@Query(value = "SELECT ra.* FROM t_route_allocation ra WHERE  :currDate BETWEEN ra.from_date AND ra.to_date  AND  ra.supervisor_id=:supervisorId", nativeQuery = true)
	RouteAllocation getRouteAllocation(@Param("currDate") String currDate, @Param("supervisorId") int supervisorId);

}
