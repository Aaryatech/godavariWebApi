package com.ats.godaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.godaapi.model.ErrorMessage;
import com.ats.godaapi.model.Order;
import com.ats.godaapi.model.OrderDetail;
import com.ats.godaapi.repository.OrderDetailRepo;
import com.ats.godaapi.repository.OrderRepo;

@RestController
public class OrderApiController {

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	OrderDetailRepo orderDetailRepo;

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
}
