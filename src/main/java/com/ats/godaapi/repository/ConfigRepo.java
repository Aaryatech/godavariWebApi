package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Config;

public interface ConfigRepo extends JpaRepository<Config, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Config SET isUsed=0    WHERE config_id=:configId ")
	int deleteConfig(@Param("configId") int configId);

	List<Config> findByIsUsed(int i);

	Config findByConfigIdAndIsUsed(int configId, int i);

}
