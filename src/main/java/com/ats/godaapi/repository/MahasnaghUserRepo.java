package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.MahasnaghUser;

public interface MahasnaghUserRepo extends JpaRepository<MahasnaghUser, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE MahasnaghUser SET isUsed=0    WHERE ms_id=:msId ")
	int deleteMahasnaghUser(@Param("msId") int msId);

	List<MahasnaghUser> findByIsUsed(int i);

	MahasnaghUser findByMsIdAndIsUsed(int msId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE MahasnaghUser SET isBlock=0    WHERE ms_id=:msId ")
	int blockMahasnaghUser(@Param("msId") int msId);

	MahasnaghUser findByMsContactNoAndMsPwdAndIsUsed(String msContactNo, String msPwd, int i);

	MahasnaghUser findByMsContactNoAndIsUsed(String msContactNo, int i);

}
