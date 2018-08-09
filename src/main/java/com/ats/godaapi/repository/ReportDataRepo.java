package com.ats.godaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.godaapi.model.ReportData;

public interface ReportDataRepo extends JpaRepository<ReportData, Integer> {

	ReportData findByDataId(int dataId);

}
