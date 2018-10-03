package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Uom;

public interface UomRepo extends JpaRepository<Uom, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Uom SET isUsed=0    WHERE uom_id=:uomId ")
	int deleteUom(@Param("uomId") int uomId);

	Uom findByUomIdAndIsUsed(int uomId, int i);

	List<Uom> findByIsUsedOrderByUomIdDesc(int i);

	

}
