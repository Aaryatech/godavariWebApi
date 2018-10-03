package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.MahasanghUser;

public interface MahasnaghUserRepo extends JpaRepository<MahasanghUser, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE MahasanghUser SET isUsed=0    WHERE ms_id=:msId ")
	int deleteMahasnaghUser(@Param("msId") int msId);

	List<MahasanghUser> findByIsUsedOrderByMsIdDesc(int i);
	
	List<MahasanghUser> findByIsUsed(int i);


	MahasanghUser findByMsIdAndIsUsed(int msId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE MahasanghUser SET isBlock=0    WHERE ms_id=:msId ")
	int blockMahasnaghUser(@Param("msId") int msId);

	MahasanghUser findByMsContactNoAndMsPwdAndIsUsed(String msContactNo, String msPwd, int i);

	MahasanghUser findByMsContactNoAndIsUsed(String msContactNo, int i);

}
