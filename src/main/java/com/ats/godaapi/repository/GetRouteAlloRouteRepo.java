package com.ats.godaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.godaapi.model.GetRouteAlloRoute;

public interface GetRouteAlloRouteRepo extends JpaRepository<GetRouteAlloRoute, Integer> {

	

}
