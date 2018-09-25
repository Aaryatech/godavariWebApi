package com.ats.godaapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.godaapi.model.Distributor;
import com.ats.godaapi.model.dashreport.AllDistLatestOrd;
import com.ats.godaapi.model.dashreport.CatwiseOrderQty;
import com.ats.godaapi.model.report.DistWithLastOrders;
import com.ats.godaapi.repository.DistributorRepository;
import com.ats.godaapi.repository.reportrepo.AllDistLatestOrdRepo;
import com.ats.godaapi.repository.reportrepo.CatwiseOrderQtyByDateRepo;

@RestController
public class TempController {

	@Autowired
	AllDistLatestOrdRepo allDistLatestOrdRepo;

	@Autowired
	DistributorRepository distributorRepository;

	@Autowired
	CatwiseOrderQtyByDateRepo catwiseOrderQtyByDateRepo;

	@RequestMapping(value = { "/getGraphDataForDistwiseOrderHistory" }, method = RequestMethod.POST)
	public @ResponseBody List<DistWithLastOrders> getGraphDataForDistwiseOrderHistory(
			@RequestParam("hubId") int hubId) {

		List<DistWithLastOrders> distWithLastOrdersList = new ArrayList();

		try {

			List<Distributor> distList = distributorRepository.findByHubId(hubId);

			for (Distributor dist : distList) {

				DistWithLastOrders distWithLastOrders = new DistWithLastOrders();
				distWithLastOrders.setDistEngName(dist.getDistEngName());
				distWithLastOrders.setDistMarName(dist.getDistMarName());
				distWithLastOrders.setDistId(dist.getDistId());

				List<AllDistLatestOrd> latestOrds = allDistLatestOrdRepo.getAllDistLastestOrdList(dist.getDistId());

				for (int i = 0; i < latestOrds.size(); i++) {

					AllDistLatestOrd ord = latestOrds.get(i);

					if (i == 0) {
						distWithLastOrders.setOrder1(ord.getOrderTotal());
					} else if (i == 1) {
						distWithLastOrders.setOrder2(ord.getOrderTotal());
					} else if (i == 2) {
						distWithLastOrders.setOrder3(ord.getOrderTotal());
					}

				}

				distWithLastOrdersList.add(distWithLastOrders);
			}

			System.err.println("allDistLatestOrdList : " + distWithLastOrdersList.toString());

		} catch (Exception e) {
			System.err.println("AllDistLastestOrder " + e.getMessage());
			e.printStackTrace();
		}

		return distWithLastOrdersList;

	}

	@RequestMapping(value = { "/getCatwiseTrend" }, method = RequestMethod.POST)
	public @ResponseBody List<DistWithLastOrders> getCatwiseTrend(@RequestParam("hubId") int hubId,
			@RequestParam("days") int days) {

		List<DistWithLastOrders> distWithLastOrdersList = new ArrayList();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		String todaysDate = dateFormat.format(date);
		System.out.println(todaysDate);

		try {
				for (int i = 0; i < days; i++) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();
				
				c.setTime(sdf.parse(todaysDate));
				c.add(Calendar.DATE, 1); 
				todaysDate = sdf.format(c.getTime());
				System.out.println("Day "+i +" Date After Increment " + todaysDate);
				
				
				List<CatwiseOrderQty> list = catwiseOrderQtyByDateRepo.getCatOrderQtyByDate(todaysDate, hubId);
				System.out.println("List  " + list.toString());

				
				
			}

		} catch (Exception e) {

		}

		return distWithLastOrdersList;
	}
}
