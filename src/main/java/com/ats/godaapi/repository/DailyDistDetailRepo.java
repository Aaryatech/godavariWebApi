package com.ats.godaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.DailyDistDetail;

public interface DailyDistDetailRepo extends JpaRepository<DailyDistDetail, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE DailyDistDetail SET dayEndTime=:dayEndTime   WHERE detail_id=:detailId AND supervisor_id=:supervisorId")
	int updateDailyDistDetail(@Param("detailId") int detailId, @Param("supervisorId") int supervisorId,
			@Param("dayEndTime") String dayEndTime);

}
