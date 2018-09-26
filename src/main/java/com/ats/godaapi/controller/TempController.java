package com.ats.godaapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.godaapi.model.Category;
import com.ats.godaapi.model.Distributor;
import com.ats.godaapi.model.dashreport.AllDistLatestOrd;
import com.ats.godaapi.model.dashreport.CatwiseOrderQty;
import com.ats.godaapi.model.dashreport.DatewiseCatQty;
import com.ats.godaapi.model.report.CategoryDistReport;
import com.ats.godaapi.model.report.DistWithLastOrders;
import com.ats.godaapi.repository.CategoryRepo;
import com.ats.godaapi.repository.DistributorRepository;
import com.ats.godaapi.repository.reportrepo.AllDistLatestOrdRepo;
import com.ats.godaapi.repository.reportrepo.CategoryDistReportRepo;
import com.ats.godaapi.repository.reportrepo.CatwiseOrderQtyByDateRepo;

@RestController
public class TempController {

	@Autowired
	AllDistLatestOrdRepo allDistLatestOrdRepo;

	@Autowired
	DistributorRepository distributorRepository;

	@Autowired
	CatwiseOrderQtyByDateRepo catwiseOrderQtyByDateRepo;

	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	CategoryDistReportRepo categoryDistReportRepo;


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
	public @ResponseBody HashMap<String, Object> getCatwiseTrend(@RequestParam("hubId") int hubId,
			@RequestParam("days") int days) {

		HashMap<String, Object> map = new HashMap<>();

		List<DistWithLastOrders> distWithLastOrdersList = new ArrayList();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		String todaysDate = dateFormat.format(date);

		System.out.println(days);

		System.out.println(todaysDate);

		List<Category> catList = categoryRepo.findByIsUsed(1);
		map.put("catList", catList);

		List<DatewiseCatQty> orderQtyList = new ArrayList();
		try {
			for (int i = 0; i < days; i++) {

				System.out.println("Day " + i + " Date After Increment " + todaysDate);

			//	List<CategoryDistReport> list=	categoryDistReportRepo.getHubReportCatWise(todaysDate, hubId);
				List<CatwiseOrderQty> list = catwiseOrderQtyByDateRepo.getCatOrderQtyByDate(todaysDate, hubId);
				System.out.println("List  " + list.toString());

				DatewiseCatQty catQty = new DatewiseCatQty();
				catQty.setDate(todaysDate);

				List<Integer> qtyList = new ArrayList();
				
		
				
				for (Category category : catList) {

					qtyList.add(0);
					for (CatwiseOrderQty catOrder : list) {

						if (catOrder.getCatId() == category.getCatId()) {

							qtyList.set(qtyList.size() - 1, catOrder.getOrderQty());
						}
					}

				}
				catQty.setOrderQty(qtyList);
				orderQtyList.add(catQty);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();

				c.setTime(sdf.parse(todaysDate));
				c.add(Calendar.DATE, 1);
				todaysDate = sdf.format(c.getTime());
			}
			map.put("orderList", orderQtyList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
}
