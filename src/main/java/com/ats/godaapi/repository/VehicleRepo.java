package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	List<Vehicle> findByIsUsed(int i);

	Vehicle findByVehicleIdAndIsUsed(int vehicleId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE Vehicle SET isUsed=0    WHERE vehicle_id=:vehicleId ")
	int deleteVehicle(@Param("vehicleId") int vehicleId);

}
