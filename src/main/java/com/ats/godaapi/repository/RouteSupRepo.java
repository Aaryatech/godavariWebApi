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

	RouteSup findBySupContactNoAndSupPwdAndIsUsed(String supContactNo, String supPwd, int i);

	@Transactional
	@Modifying
	@Query("UPDATE RouteSup SET isBlock=0    WHERE sup_id=:supId ")
	int blockRouteSup(@Param("supId") int supId);

	@Query(value = "SELECT v.* FROM m_route_supervisor v  WHERE v.sup_id NOT IN (SELECT supervisor_id FROM t_route_allocation "
			+ "WHERE  :fromDate BETWEEN t_route_allocation.from_date AND t_route_allocation.to_date AND :toDate BETWEEN"
			+ " t_route_allocation.from_date AND t_route_allocation.to_date  ) AND v.is_used=1", nativeQuery = true)
	List<RouteSup> getSupBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
