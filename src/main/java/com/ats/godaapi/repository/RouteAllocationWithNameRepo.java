package com.ats.godaapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.RouteAllocationWithName;

public interface RouteAllocationWithNameRepo extends JpaRepository<RouteAllocationWithName, Integer> {

	@Query(value = "SELECT r.*,m.route_eng_name,m.route_mar_name,d.driver_eng_name,d.driver_mar_name ,d.driver_contact_no ,v.vehicle_no,s.sup_eng_name,s.sup_mar_name,s.sup_contact_no FROM  t_route_allocation r,m_route m,m_driver d ,m_vehicle v,m_route_supervisor s WHERE r.route_id=m.route_id AND d.driver_id=r.driver_id AND r.vehicle_id=v.vehicle_id AND r.supervisor_id= s.sup_id AND :currDate BETWEEN r.from_date AND r.to_date ", nativeQuery = true)
	List<RouteAllocationWithName> getRouteAllocationDatewise(@Param("currDate") String currDate);

}
