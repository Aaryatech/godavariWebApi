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

import com.ats.godaapi.model.ErrorMessage;
import com.ats.godaapi.model.GetOrder;
import com.ats.godaapi.model.GetOrderDetail;
import com.ats.godaapi.model.Item;
import com.ats.godaapi.model.Order;
import com.ats.godaapi.model.OrderDetail;
import com.ats.godaapi.repository.GetOrderDetailRepo;
import com.ats.godaapi.repository.GetOrderRepo;
import com.ats.godaapi.repository.ItemRepo;
import com.ats.godaapi.repository.OrderDetailRepo;
import com.ats.godaapi.repository.OrderRepo;

@RestController
public class OrderApiController {

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	OrderDetailRepo orderDetailRepo;

	@Autowired
	ItemRepo itemRepo;

	@Autowired
	GetOrderDetailRepo getOrderDetailRepo;

	@Autowired
	GetOrderRepo getOrderRepo;

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

}
	