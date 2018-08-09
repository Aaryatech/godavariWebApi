package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Distributor;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

	Distributor findByDistIdAndIsUsed(int distId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE Distributor SET isUsed=0    WHERE dist_id=:distId ")
	int deleteDistributor(@Param("distId") int distId);

	List<Distributor> findByIsUsed(int i);
}
