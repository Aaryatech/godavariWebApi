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

	Distributor findByDistContactNoAndDistPwdAndIsUsed(String distContactNo, String distPwd, int i);

	Distributor findByDistId(int distId);

	@Transactional
	@Modifying
	@Query("UPDATE Distributor SET token=:token  WHERE dist_id=:distId")
	int updateToken(@Param("distId") int distId, @Param("token") String token);

	@Transactional
	@Modifying
	@Query("UPDATE Distributor SET isBlock=0    WHERE dist_id=:distId ")
	int blockDistributor(@Param("distId") int distId);

	List<Distributor> findByRouteIdAndIsUsed(int routeId, int i);

	@Query(value = "SELECT d.* FROM m_dist d WHERE d.is_used=1 AND d.dist_id IN(:distIdList)", nativeQuery = true)
	List<Distributor> getDistListById(@Param("distIdList") List<Integer> distIdList);

	@Transactional
	@Modifying
	@Query("UPDATE Distributor SET dist_pwd=:distPwd   WHERE dist_id=:distId ")
	Distributor updatePwd(@Param("distId") int distId, @Param("distPwd") String distPwd);

}
