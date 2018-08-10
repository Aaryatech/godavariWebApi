package com.ats.godaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.godaapi.model.GetOrder;

public interface GetOrderRepo extends JpaRepository<GetOrder, Integer> {

}
