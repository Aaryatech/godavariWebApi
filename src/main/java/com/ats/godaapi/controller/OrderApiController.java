package com.ats.godaapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.godaapi.model.Distributor;
import com.ats.godaapi.model.DistwiseOrder;
import com.ats.godaapi.model.ErrorMessage;
import com.ats.godaapi.model.GetOrder;
import com.ats.godaapi.model.GetOrderDetail;
import com.ats.godaapi.model.HubUser;
import com.ats.godaapi.model.ItemwiseOrder;
import com.ats.godaapi.model.MahasnaghUser;
import com.ats.godaapi.model.Order;
import com.ats.godaapi.model.OrderDetail;
import com.ats.godaapi.model.Setting;
import com.ats.godaapi.repository.DistributorRepository;
import com.ats.godaapi.repository.GetOrderDetailRepo;
import com.ats.godaapi.repository.GetOrderRepo;
import com.ats.godaapi.repository.HubUserRepo;
import com.ats.godaapi.repository.ItemRepo;
import com.ats.godaapi.repository.ItemwiseOrderRepo;
import com.ats.godaapi.repository.MahasnaghUserRepo;
import com.ats.godaapi.repository.OrderDetailRepo;
import com.ats.godaapi.repository.OrderRepo;
import com.ats.godaapi.repository.SettingRepo;

@RestController
public class OrderApiController {

	@Autowired
	HubUserRepo hubUserRepo;

	@Autowired
	SettingRepo settingRepo;

	@Autowired
	MahasnaghUserRepo mahasnaghUserRepo;

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	ItemwiseOrderRepo itemwiseOrderRepo;

	@Autowired
	OrderDetailRepo orderDetailRepo;

	@Autowired
	ItemRepo itemRepo;

	@Autowired
	GetOrderDetailRepo getOrderDetailRepo;

	@Autowired
	GetOrderRepo getOrderRepo;

	@Autowired
	DistributorRepository distributorRepository;

	@RequestMapping(value = { "/saveOrderHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveOrderHeaderDetail(@RequestBody Order order) {

		ErrorMessage errorMessage = new ErrorMessage();

		Order orderRes = new Order();

		try {

			System.out.println("inputs" + order);

			orderRes = orderRepo.saveAndFlush(order);
			System.out.println("orderResListDeatil" + orderRes.getOrderDetailList());

			for (int i = 0; i < order.getOrderDetailList().size(); i++) {
				order.getOrderDetailList().get(i).setOrderHeaderId(orderRes.getOrderHeaderId());

				List<OrderDetail> orderDetailList = orderDetailRepo.saveAll(order.getOrderDetailList());
				System.out.println("orderDetailList" + orderDetailList.toString());
				orderRes.setOrderDetailList(orderDetailList);
			}
			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getOrderHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody Order getOrderHeaderAndDetail(@RequestParam("orderHeaderId") int orderHeaderId) {

		Order orderHeader = new Order();

		try {

			orderHeader = orderRepo.findByOrderHeaderId(orderHeaderId);
			List<OrderDetail> orderDetailList = orderDetailRepo.findByOrderHeaderId(orderHeaderId);
			orderHeader.setOrderDetailList(orderDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderHeader;

	}

	@RequestMapping(value = { "/getOrderHeaderAndDetailByDistId" }, method = RequestMethod.POST)
	public @ResponseBody List<Order> getOrderHeaderAndDetailByDistId(@RequestParam("distId") int distId) {

		List<Order> orderHeaderList = new ArrayList<Order>();

		try {

			orderHeaderList = orderRepo.findByDistId(distId);

			for (int i = 0; i < orderHeaderList.size(); i++) {
				List<OrderDetail> orderDetailList = orderDetailRepo
						.findByOrderHeaderId(orderHeaderList.get(i).getOrderHeaderId());
				orderHeaderList.get(i).setOrderDetailList(orderDetailList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderHeaderList;

	}

	@RequestMapping(value = { "/getOrderByItemId" }, method = RequestMethod.POST)
	public @ResponseBody List<OrderDetail> getOrderByItemId(@RequestParam("itemId") int itemId) {

		List<OrderDetail> itemList = new ArrayList<OrderDetail>();
		try {
			itemList = orderDetailRepo.findByItemId(itemId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/getOrderHistory" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrder> getOrderHistory(@RequestParam("orderDate") String orderDate) {

		List<GetOrder> orderHeaderList = new ArrayList<GetOrder>();

		try {

			orderHeaderList = getOrderRepo.getOrderHeaderlHistory(orderDate);

			for (int i = 0; i < orderHeaderList.size(); i++) {
				List<GetOrderDetail> orderDetailList = getOrderDetailRepo
						.getOrderDetailHistory(orderHeaderList.get(i).getOrderHeaderId());
				orderHeaderList.get(i).setGetOrderDetailList(orderDetailList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderHeaderList;

	}

	@RequestMapping(value = { "/updateOrderHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateOrderHeaderAndDetail(@RequestBody List<Order> orderList) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			for (int i = 0; i < orderList.size(); i++) {
				Order orderHeader = orderRepo.save(orderList.get(i));

				for (int j = 0; j < orderList.get(i).getOrderDetailList().size(); j++) {

					orderList.get(i).getOrderDetailList().get(j).setOrderHeaderId(orderHeader.getOrderHeaderId());

				}

				List<OrderDetail> orderDetailsList = orderDetailRepo.saveAll(orderList.get(i).getOrderDetailList());
				System.out.println("orderDetailsList" + orderDetailsList.toString());
			}

			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getOrderItemwise" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrder> getOrderItemwise(@RequestParam("date") String date) {

		List<GetOrder> orderHeaderList = new ArrayList<GetOrder>();

		try {

			orderHeaderList = getOrderRepo.getOrderItemwise(date);

			for (int i = 0; i < orderHeaderList.size(); i++) {
				List<GetOrderDetail> orderDetailList = getOrderDetailRepo
						.getOrderDetailByItemwise(orderHeaderList.get(i).getOrderHeaderId());
				orderHeaderList.get(i).setGetOrderDetailList(orderDetailList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderHeaderList;

	}

	@RequestMapping(value = { "/getItemwiseOrder" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemwiseOrder> getItemwiseOrder(@RequestParam("orderDate") String orderDate) {

		List<ItemwiseOrder> orderList = new ArrayList<ItemwiseOrder>();

		try {

			orderList = itemwiseOrderRepo.getItemwiseOrder(orderDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderList;

	}

	@RequestMapping(value = { "/getDistwiseOrder" }, method = RequestMethod.POST)
	public @ResponseBody List<DistwiseOrder> getDistwiseOrder(@RequestParam("orderDate") String orderDate) {

		List<DistwiseOrder> distOrderList = new ArrayList<DistwiseOrder>();

		List<Distributor> distList = new ArrayList<>();

		try {

			distList = distributorRepository.findByIsUsed(1);

			for (int i = 0; i < distList.size(); i++) {

				List<GetOrderDetail> orderDetailList = getOrderDetailRepo
						.getDistwiseOrderDetail(distList.get(i).getDistId(), orderDate);

				if (!orderDetailList.isEmpty()) {
					DistwiseOrder distwiseOrder = new DistwiseOrder();
					distwiseOrder.setDistAddEng(distList.get(i).getDistAddEng());
					distwiseOrder.setDistAddMar(distList.get(i).getDistAddMar());

					distwiseOrder.setDistAmtLimit(distList.get(i).getDistAmtLimit());

					distwiseOrder.setDistAmtPending(distList.get(i).getDistAmtPending());
					distwiseOrder.setDistContactNo(distList.get(i).getDistContactNo());
					distwiseOrder.setDistCratesLimit(distList.get(i).getDistCratesLimit());
					distwiseOrder.setDistCratesPending(distList.get(i).getDistCratesPending());
					distwiseOrder.setDistEngName(distList.get(i).getDistAddEng());
					distwiseOrder.setDistId(distList.get(i).getDistId());

					distwiseOrder.setDistLocation(distList.get(i).getDistLocation());
					distwiseOrder.setDistMarName(distList.get(i).getDistMarName());
					distwiseOrder.setDistPwd(distList.get(i).getDistPwd());
					distwiseOrder.setHubId(distList.get(i).getHubId());
					distwiseOrder.setIsBlock(distList.get(i).getIsBlock());
					distwiseOrder.setIsUsed(distList.get(i).getIsUsed());
					distwiseOrder.setRouteDistSeqNo(distList.get(i).getRouteDistSeqNo());
					distwiseOrder.setRouteId(distList.get(i).getRouteId());
					distwiseOrder.setToken(distList.get(i).getToken());
					distwiseOrder.setGetOrderDetailList(orderDetailList);
					distOrderList.add(distwiseOrder);

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return distOrderList;

	}

	@RequestMapping(value = { "/saveOrderBySetting" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveOrderBySetting(@RequestBody Order order) {

		ErrorMessage errorMessage = new ErrorMessage();
		Order orderRes = new Order();
		System.out.println("orderList" + order.toString());
		List<Setting> setList = new ArrayList<Setting>();

		try {

			DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
			Date date = new Date();
			String time = dateFormat.format(date);
			System.out.println(time);

			Calendar calobj = Calendar.getInstance();
			System.out.println(calobj.getTime());

			setList = settingRepo.getTime(time);
			System.out.println("SetList" + setList.toString());
			if (!setList.isEmpty()) {
				orderRes = orderRepo.saveAndFlush(order);
				System.out.println("orderResListDeatil" + orderRes.getOrderDetailList());

				for (int i = 0; i < order.getOrderDetailList().size(); i++) {
					order.getOrderDetailList().get(i).setOrderHeaderId(orderRes.getOrderHeaderId());

					List<OrderDetail> orderDetailList = orderDetailRepo.saveAll(order.getOrderDetailList());
					System.out.println("orderDetailList" + orderDetailList.toString());
					orderRes.setOrderDetailList(orderDetailList);
				}
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Saved ");
			} else {
				errorMessage.setMessage("Time not Match");

			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/saveDistributorBySetting" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveDistributorBySetting(@RequestBody Distributor distributor) {

		ErrorMessage errorMessage = new ErrorMessage();
		Distributor distRes = new Distributor();

		System.out.println("distributor" + distributor.toString());
		List<Setting> setList = new ArrayList<Setting>();

		try {

			DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
			Date date = new Date();
			String time = dateFormat.format(date);
			System.out.println(time);

			Calendar calobj = Calendar.getInstance();
			System.out.println(calobj.getTime());

			setList = settingRepo.getTime(time);
			System.out.println("SetList" + setList.toString());
			if (!setList.isEmpty()) {
				distRes = distributorRepository.saveAndFlush(distributor);

				errorMessage.setError(false);
				errorMessage.setMessage("successfully Saved ");
			} else {
				errorMessage.setMessage("Time not Match");

			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}

/*	@RequestMapping(value = { "/saveMahasanghUserBySetting" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveMahasanghUserBySetting(@RequestBody MahasnaghUser mah) {

		ErrorMessage errorMessage = new ErrorMessage();
		MahasnaghUser mahRes = new MahasnaghUser();

		System.out.println("mahRes" + mahRes.toString());
		List<Setting> setList = new ArrayList<Setting>();

		try {

			DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
			Date date = new Date();
			String time = dateFormat.format(date);
			System.out.println(time);

			Calendar calobj = Calendar.getInstance();
			System.out.println(calobj.getTime());

			setList = settingRepo.getTime(time);
			System.out.println("SetList" + setList.toString());
			if (!setList.isEmpty()) {
				mahRes = mahasnaghUserRepo.saveAndFlush(mah);

				errorMessage.setError(false);
				errorMessage.setMessage("successfully Saved ");
			} else {
				errorMessage.setMessage("Time not Match");

			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}*/

	@RequestMapping(value = { "/saveHubUserBySetting" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveHubUserBySetting(@RequestBody HubUser hubUser) {

		ErrorMessage errorMessage = new ErrorMessage();
		HubUser res = new HubUser();

		System.out.println("hubUser" + hubUser.toString());
		List<Setting> setList = new ArrayList<Setting>();

		try {

			DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
			Date date = new Date();
			String time = dateFormat.format(date);
			System.out.println(time);

			Calendar calobj = Calendar.getInstance();
			System.out.println(calobj.getTime());

			setList = settingRepo.getTime(time);
			System.out.println("SetList" + setList.toString());
			if (!setList.isEmpty()) {
				res = hubUserRepo.saveAndFlush(hubUser);

				errorMessage.setError(false);
				errorMessage.setMessage("successfully Saved ");
			} else {
				errorMessage.setMessage("Time not Match");

			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}

}