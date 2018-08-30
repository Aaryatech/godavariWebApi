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

}
