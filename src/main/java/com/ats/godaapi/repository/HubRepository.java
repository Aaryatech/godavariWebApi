package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Hub;

public interface HubRepository extends JpaRepository<Hub, Integer> {

	Hub findByHubIdAndIsUsed(int hubId, int i);

	List<Hub> findByIsUsed(int i);

	List<Hub> findByIsUsedOrderByHubIdDesc(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Hub SET isUsed=0    WHERE hub_id=:hubId ")
	int deleteHub(@Param("hubId") int hubId);

	List<Hub> findByHubContactNoOrHubEngNameIgnoreCaseContainingAndIsUsed(String mobNo, String hubName, int isUsed);

	// List<Hub> findByHubContactNoOrHubEngNameIgnoreCaseContainining(String mobNo,
	// String hubName);

}
