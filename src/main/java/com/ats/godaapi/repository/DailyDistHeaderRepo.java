package com.ats.godaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.godaapi.model.DailyDistHeader;

public interface DailyDistHeaderRepo extends JpaRepository<DailyDistHeader, Integer> {

	DailyDistHeader findByRouteIdAndDate(int routeId, String date);

}
