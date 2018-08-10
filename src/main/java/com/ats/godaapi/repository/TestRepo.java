package com.ats.godaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.godaapi.model.Test;

public interface TestRepo extends JpaRepository<Test, Integer> {

}
