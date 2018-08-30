package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Driver;

public interface DriverRepo extends JpaRepository<Driver, Integer> {

	List<Driver> findByIsUsed(int i);

	Driver findByDriverIdAndIsUsed(int driverId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE Driver SET isUsed=0    WHERE driver_id=:driverId ")
	int deleteDriver(@Param("driverId") int driverId);

	@Query(value = "SELECT d.* FROM m_driver d  WHERE d.driver_id NOT IN (SELECT driver_id FROM t_route_allocation WHERE  "
			+ ":fromDate BETWEEN t_route_allocation.from_date AND t_route_allocation.to_date AND :toDate BETWEEN"
			+ " t_route_allocation.from_date AND t_route_allocation.to_date  ) AND d.is_used=1", nativeQuery = true)
	List<Driver> getDriverBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
