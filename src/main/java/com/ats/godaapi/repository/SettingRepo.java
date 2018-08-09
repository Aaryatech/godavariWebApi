package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Setting;

public interface SettingRepo extends JpaRepository<Setting, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Setting SET isUsed=0    WHERE setting_id=:settingId ")
	int deleteSetting(@Param("settingId") int settingId);

	List<Setting> findByIsUsed(int i);

	Setting findBySettingIdAndIsUsed(int settingId, int i);

}
