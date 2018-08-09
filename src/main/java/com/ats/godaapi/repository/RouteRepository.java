package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Route SET isUsed=0    WHERE route_id=:routeId ")
	int deleteRoute(@Param("routeId") int routeId);

	Route findByRouteIdAndIsUsed(int routeId, int i);

	List<Route> findByIsUsed(int i);

}
