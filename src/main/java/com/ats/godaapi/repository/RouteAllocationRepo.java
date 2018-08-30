package com.ats.godaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.godaapi.model.RouteAllocation;

public interface RouteAllocationRepo extends JpaRepository<RouteAllocation, Integer> {

	RouteAllocation findByTrId(int trId);

}
