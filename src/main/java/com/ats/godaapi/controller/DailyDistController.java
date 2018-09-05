package com.ats.godaapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.godaapi.model.DailyDistDetail;
import com.ats.godaapi.model.DailyDistHeader;
import com.ats.godaapi.model.ErrorMessage;
import com.ats.godaapi.repository.DailyDistDetailRepo;
import com.ats.godaapi.repository.DailyDistHeaderRepo;

@RestController
public class DailyDistController {

	@Autowired
	DailyDistDetailRepo dailyDistDetailRepo;

	@Autowired
	DailyDistHeaderRepo dailyDistHeaderRepo;

	// -------------------DailyDistHeader------------------------

	@RequestMapping(value = { "/saveDailyDistHeader" }, method = RequestMethod.POST)
	public @ResponseBody List<DailyDistHeader> saveDailyDistHeader(@RequestBody List<DailyDistHeader> dailyDistHeader) {

		List<DailyDistHeader> res = new ArrayList<>();

		try {

			res = dailyDistHeaderRepo.saveAll(dailyDistHeader);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getDailyDistByRouteId" }, method = RequestMethod.POST)
	public @ResponseBody DailyDistHeader getDailyDistByRouteId(@RequestParam("routeId") int routeId,
			@RequestParam("date") String date) {

		DailyDistHeader dailyDistHeader = null;
		try {
			dailyDistHeader = dailyDistHeaderRepo.findByRouteIdAndDate(routeId, date);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dailyDistHeader;

	}

	@RequestMapping(value = { "/getDailyDistByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<DailyDistHeader> getDailyDistByDate(@RequestParam("date") String date) {
		List<DailyDistHeader> dailyDistHeaderList = new ArrayList<>();

		try {
			dailyDistHeaderList = dailyDistHeaderRepo.findByDate(date);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dailyDistHeaderList;

	}

	// -------------------DailyDistDeatil------------------------

	@RequestMapping(value = { "/saveDailyDistDetail" }, method = RequestMethod.POST)
	public @ResponseBody DailyDistDetail saveDailyDistDetail(@RequestBody DailyDistDetail dailyDistDetail) {

		DailyDistDetail res = new DailyDistDetail();

		try {

			res = dailyDistDetailRepo.saveAndFlush(dailyDistDetail);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/updateDailyDistDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateDailyDistDetail(@RequestParam("detailId") int detailId,
			@RequestParam("supervisorId") int supervisorId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currDateTime = sdf.format(now.getTime());

			int delete = dailyDistDetailRepo.updateDailyDistDetail(detailId, supervisorId, currDateTime);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Updated Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Update Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}
}
