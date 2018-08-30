package com.ats.godaapi.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.godaapi.model.Driver;
import com.ats.godaapi.model.GetRoute;
import com.ats.godaapi.model.ReportData;
import com.ats.godaapi.model.RouteSup;
import com.ats.godaapi.model.Vehicle;
import com.ats.godaapi.repository.DriverRepo;
import com.ats.godaapi.repository.GetRouteRepo;
import com.ats.godaapi.repository.ReportDataRepo;
import com.ats.godaapi.repository.RouteSupRepo;
import com.ats.godaapi.repository.VehicleRepo;

@RestController
public class ReportDataApiController {

	@Autowired
	ReportDataRepo reportDataRepo;

	@Autowired
	GetRouteRepo getRouteRepo;

	@Autowired
	VehicleRepo vehicleRepo;

	@Autowired
	RouteSupRepo routeSupRepo;

	@Autowired
	DriverRepo driverRepo;
	// -------------------Report data------------------------

	@RequestMapping(value = { "/saveReportData" }, method = RequestMethod.POST)
	public @ResponseBody ReportData saveReportData(@RequestBody ReportData reportData) {

		ReportData res = new ReportData();

		try {

			res = reportDataRepo.saveAndFlush(reportData);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getReportByDataId" }, method = RequestMethod.POST)
	public @ResponseBody ReportData getReportByDataId(@RequestParam("dataId") int dataId) {

		ReportData reportData = null;
		try {
			reportData = reportDataRepo.findByDataId(dataId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return reportData;

	}

	@RequestMapping(value = { "/getAllReports" }, method = RequestMethod.GET)
	public @ResponseBody List<ReportData> getAllReports() {

		List<ReportData> dataList = new ArrayList<ReportData>();

		try {

			dataList = reportDataRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dataList;

	}
//---Route Between Date-------------------------

	@RequestMapping(value = { "/getRouteBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRoute> getRouteBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetRoute> routeList = new ArrayList<GetRoute>();

		try {

			routeList = getRouteRepo.getRouteBetDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return routeList;

	}

	@RequestMapping(value = { "/getVehicleBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<Vehicle> getVehicleBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<Vehicle> vehList = new ArrayList<Vehicle>();

		try {

			vehList = vehicleRepo.getVehicleBetDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vehList;

	}

	@RequestMapping(value = { "/getSupBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<RouteSup> getSupBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<RouteSup> supList = new ArrayList<RouteSup>();

		try {

			supList = routeSupRepo.getSupBetDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return supList;

	}

	@RequestMapping(value = { "/getDriverBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<Driver> getDriverBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<Driver> driverList = new ArrayList<Driver>();

		try {

			driverList = driverRepo.getDriverBetDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return driverList;

	}
}
