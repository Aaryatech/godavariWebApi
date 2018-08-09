package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.godaapi.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Category SET isUsed=0    WHERE cat_id=:catId ")
	int deleteCategory(@Param("catId") int catId);

	List<Category> findByIsUsed(int i);

	Category findByCatIdAndIsUsed(int catId, int i);

}
