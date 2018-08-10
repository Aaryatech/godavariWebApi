package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Item SET isUsed=0    WHERE item_id=:itemId ")
	int deleteItem(@Param("itemId") int itemId);

	List<Item> findByIsUsed(int i);

	Item findByItemIdAndIsUsed(int itemId, int i);

	List<Item> findByCatIdAndIsUsed(int catId, int i);

	List<Item> findByCatId(int catId);

}
