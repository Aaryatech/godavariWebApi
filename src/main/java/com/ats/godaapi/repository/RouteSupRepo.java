package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.RouteSup;

public interface RouteSupRepo extends JpaRepository<RouteSup, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE RouteSup SET isUsed=0    WHERE sup_id=:supId ")
	int deleteRouteSup(@Param("supId") int supId);

	List<RouteSup> findByIsUsed(int i);

	RouteSup findBySupIdAndIsUsed(int supId, int i);

}
