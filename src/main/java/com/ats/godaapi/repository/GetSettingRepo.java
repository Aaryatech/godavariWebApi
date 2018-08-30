package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.godaapi.model.GetSetting;

public interface GetSettingRepo extends JpaRepository<GetSetting, Integer> {

	@Query(value = "SELECT s.*,h.hub_eng_name,h.hub_mar_name,h.hub_eng_add,h.hub_mar_add ,c. config_eng_name,c.config_mar_name,"
			+ "c.dist_from_time,c.dist_to_time,c.hub_from_time,c.hub_to_time,c.item_ids,c.config_type,c.config_type_details,"
			+ "c.item_ids FROM t_setting s ,m_hub h ,t_config c WHERE s.is_used=1 AND h.hub_id=s.hub_id AND"
			+ " c.config_id=s.config_id", nativeQuery = true)
	List<GetSetting> getSetting();

}
