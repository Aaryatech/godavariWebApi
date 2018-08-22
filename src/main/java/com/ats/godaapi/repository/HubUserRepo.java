package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.GetOrderDetail;
import com.ats.godaapi.model.HubUser;

public interface HubUserRepo extends JpaRepository<HubUser, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE HubUser SET isUsed=0    WHERE hs_id=:hsId ")
	int deleteHubUser(@Param("hsId") int hsId);

	@Transactional
	@Modifying
	@Query("UPDATE HubUser SET isBlock=0    WHERE hs_id=:hsId ")
	int blockHubUser(@Param("hsId") int hsId);

	List<HubUser> findByIsUsed(int i);

	HubUser findByHsIdAndIsUsed(int hsId, int i);

	HubUser findByHsContactNoAndHsPwdAndIsUsed(String hsContactNo, String hsPwd, int i);

	HubUser findByHsContactNoAndIsUsed(String hsContactNo, int i);

	@Query(value = "SELECT * FROM m_hub_user h WHERE h.is_used=1 AND h.is_admin IN(:userType) ", nativeQuery = true)
	List<HubUser> getHubUserByUserType(@Param("userType") List<Integer> userType);

}
