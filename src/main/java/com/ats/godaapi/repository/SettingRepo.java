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

	@Query(value = "SELECT s.* FROM  t_setting s,m_dist d,t_config c  WHERE d.hub_id=s.hub_id  AND s.config_id=c.config_id AND TIME(:currentTime) >= TIME(c.dist_from_time) AND TIME(:currentTime) <=TIME(c.dist_to_time)", nativeQuery = true)
	List<Setting> getTime(@Param("currentTime") String time);

	@Query(value = "SELECT s.* FROM  t_setting s,m_hub d,t_config c  WHERE d.hub_id=s.hub_id  AND s.config_id=c.config_id AND TIME(:currentTime) >= TIME(c.hub_from_time) AND TIME(:currentTime) <=TIME(c.hub_to_time)", nativeQuery = true)
	List<Setting> getTimeForHub(@Param("currentTime") String time);

}
