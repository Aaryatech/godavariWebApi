package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetCatItemList;
import com.ats.godaapi.model.GetOrderDetail;

public interface GetCatItemListRepo extends JpaRepository<GetCatItemList, Integer> {

	

}
