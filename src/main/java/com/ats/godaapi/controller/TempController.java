package com.ats.godaapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.godaapi.model.Distributor;
import com.ats.godaapi.model.dashreport.AllDistLatestOrd;
import com.ats.godaapi.model.report.DistWithLastOrders;
import com.ats.godaapi.repository.DistributorRepository;
import com.ats.godaapi.repository.reportrepo.AllDistLatestOrdRepo;

@RestController
public class TempController {

	@Autowired
	AllDistLatestOrdRepo allDistLatestOrdRepo;

	@Autowired
	DistributorRepository distributorRepository;

	@RequestMapping(value = { "/getGraphDataForDistwiseOrderHistory" }, method = RequestMethod.POST)
	public @ResponseBody List<DistWithLastOrders> getGraphDataForDistwiseOrderHistory(@RequestParam("hubId") int hubId) {

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
}
