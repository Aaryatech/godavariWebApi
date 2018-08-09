package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.ItemHsn;

public interface ItemHsnRepo extends JpaRepository<ItemHsn, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE ItemHsn SET isUsed=0    WHERE item_hsn_id=:itemHsnId ")
	int deleteItemHsn(@Param("itemHsnId") int itemHsnId);

	ItemHsn findByItemHsnIdAndIsUsed(int itemHsnId, int i);

	List<ItemHsn> findByIsUsed(int i);

}
