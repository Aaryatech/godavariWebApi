package com.ats.godaapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.godaapi.model.DatewiseRoute;
import com.ats.godaapi.model.Driver;
import com.ats.godaapi.model.GetRoute;
import com.ats.godaapi.model.ReportData;
import com.ats.godaapi.model.RouteAllocationWithName;
import com.ats.godaapi.model.RouteSup;
import com.ats.godaapi.model.Vehicle;
import com.ats.godaapi.model.report.CategoryDistReport;
import com.ats.godaapi.model.report.DistReportByDate;
import com.ats.godaapi.model.report.ItemwiseDistReport;
import com.ats.godaapi.repository.DriverRepo;
import com.ats.godaapi.repository.GetRouteRepo;
import com.ats.godaapi.repository.ReportDataRepo;
import com.ats.godaapi.repository.RouteAllocationWithNameRepo;
import com.ats.godaapi.repository.RouteSupRepo;
import com.ats.godaapi.repository.VehicleRepo;
import com.ats.godaapi.repository.reportrepo.CategoryDistReportRepo;
import com.ats.godaapi.repository.reportrepo.DistReportByDateRepo;
import com.ats.godaapi.repository.reportrepo.ItemwiseDistReportRepo;

@RestController
public class ReportDataApiController {

	@Autowired
	ReportDataRepo reportDataRepo;

	@Autowired
	RouteAllocationWithNameRepo routeAllocationWithNameRepo;

	@Autowired
	GetRouteRepo getRouteRepo;

	@Autowired
	VehicleRepo vehicleRepo;

	@Autowired
	RouteSupRepo routeSupRepo;

	@Autowired
	DriverRepo driverRepo;

	// sachin'
	@Autowired 
	DistReportByDateRepo distReportByDateRepo;

	@Autowired 
	ItemwiseDistReportRepo itemwiseDistReportRepo;
	
	@Autowired 
	CategoryDistReportRepo categoryDistReportRepo;
	
	@RequestMapping(value = { "/getcategoryDistReport" }, method = RequestMethod.POST)
	public @ResponseBody List<CategoryDistReport> getcategoryDistReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("distIdList") List<Integer> distIdList,
			@RequestParam("orderStatus") int orderStatus) {

		List<CategoryDistReport> cateDistReposrtList= new ArrayList<CategoryDistReport>();

		try {

			cateDistReposrtList = categoryDistReportRepo.getCategoryDistReport(fromDate, toDate, distIdList, orderStatus);
			System.err.println("cateDistReposrtList : " + cateDistReposrtList.toString());
		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return cateDistReposrtList;

	}


	@RequestMapping(value = { "/getitemwiseDistReport" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemwiseDistReport> getitemwiseDistRep(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("distIdList") List<Integer> distIdList,
			@RequestParam("orderStatus") int orderStatus) {

		List<ItemwiseDistReport> itemDistReportList= new ArrayList<ItemwiseDistReport>();

		try {

			itemDistReportList = itemwiseDistReportRepo.getItemwiseDistReport(fromDate, toDate, distIdList, orderStatus);
			System.err.println("itemDistReportList : " + itemDistReportList.toString());
		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemDistReportList;

	}

	
	@RequestMapping(value = { "/getDistReportByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<DistReportByDate> getDistReportByDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("distIdList") List<Integer> distIdList,
			@RequestParam("orderStatus") int orderStatus) {

		List<DistReportByDate> distReportList = new ArrayList<DistReportByDate>();

		try {

			distReportList = distReportByDateRepo.getDistReportByDate(fromDate, toDate, distIdList, orderStatus);
			System.err.println("distReportList : " + distReportList.toString());
		} catch (Exception e) {

			e.printStackTrace();

		}
		return distReportList;

	}

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
	// ---Route Between Date-------------------------

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

	@RequestMapping(value = { "/getRouteAllocationDatewise" }, method = RequestMethod.GET)
	public @ResponseBody List<DatewiseRoute> getRouteAllocationDatewise() {

		List<DatewiseRoute> routeDateList = new ArrayList<DatewiseRoute>();
		DatewiseRoute datewiseRoute = new DatewiseRoute();

		List<RouteAllocationWithName> routeList = new ArrayList<RouteAllocationWithName>();

		try {

			Date day1 = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sdf.format(day1.getTime());
			System.out.println("currDate" + currDate);
			System.out.println("sdf" + sdf);
			routeList = routeAllocationWithNameRepo.getRouteAllocationDatewise(currDate);
			datewiseRoute.setCurrDate(currDate);
			datewiseRoute.setRouteAllocationList(routeList);
			routeDateList.add(datewiseRoute);

			System.out.println("routeList" + routeList.toString());

			for (int i = 0; i < 4; i++) {

				datewiseRoute = new DatewiseRoute();
				day1 = new Date(day1.getTime() + TimeUnit.DAYS.toMillis(1));
				System.err.println();
				currDate = sdf.format(day1.getTime());
				routeList = routeAllocationWithNameRepo.getRouteAllocationDatewise(currDate);

				datewiseRoute.setCurrDate(currDate);
				datewiseRoute.setRouteAllocationList(routeList);
				routeDateList.add(datewiseRoute);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return routeDateList;

	}
}
