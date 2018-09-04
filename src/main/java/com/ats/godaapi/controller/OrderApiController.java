package com.ats.godaapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.godaapi.model.Category;
import com.ats.godaapi.model.Config;
import com.ats.godaapi.model.Distributor;
import com.ats.godaapi.model.DistwiseOrder;
import com.ats.godaapi.model.ErrorMessage;
import com.ats.godaapi.model.GetAllCatwiseItemResp;
import com.ats.godaapi.model.GetAllItemsForRegOrder;
import com.ats.godaapi.model.GetCatItemList;
import com.ats.godaapi.model.GetItem;
import com.ats.godaapi.model.GetOrder;
import com.ats.godaapi.model.GetOrderDetail;
import com.ats.godaapi.model.GetOrderHeader;
import com.ats.godaapi.model.GetOrderRoute;
import com.ats.godaapi.model.GetRouteData;
import com.ats.godaapi.model.HubUser;
import com.ats.godaapi.model.ItemwiseOrder;
import com.ats.godaapi.model.MahasanghUser;
import com.ats.godaapi.model.Order;
import com.ats.godaapi.model.OrderDetail;
import com.ats.godaapi.model.Route;
import com.ats.godaapi.model.RouteAllocation;
import com.ats.godaapi.model.Setting;
import com.ats.godaapi.repository.CategoryRepo;
import com.ats.godaapi.repository.ConfigRepo;
import com.ats.godaapi.repository.DistributorRepository;
import com.ats.godaapi.repository.GetAllItemsForRegOrderRepo;
import com.ats.godaapi.repository.GetItemRepo;
import com.ats.godaapi.repository.GetOrderDetailRepo;
import com.ats.godaapi.repository.GetOrderRepo;
import com.ats.godaapi.repository.GetOrderRouteRepo;
import com.ats.godaapi.repository.HubUserRepo;
import com.ats.godaapi.repository.ItemRepo;
import com.ats.godaapi.repository.ItemwiseOrderRepo;
import com.ats.godaapi.repository.MahasnaghUserRepo;
import com.ats.godaapi.repository.OrderDetailRepo;
import com.ats.godaapi.repository.OrderRepo;
import com.ats.godaapi.repository.RouteAllocationRepo;
import com.ats.godaapi.repository.RouteRepository;
import com.ats.godaapi.repository.SettingRepo;

@RestController
public class OrderApiController {

	@Autowired
	HubUserRepo hubUserRepo;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	GetItemRepo getItemRepo;

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

	@Autowired
	ConfigRepo configRepo;

	@Autowired
	GetAllItemsForRegOrderRepo getAllItemsForRegOrderRepo;

	@Autowired
	RouteAllocationRepo routeAllocationRepo;

	@Autowired
	RouteRepository routeRepository;

	@Autowired
	GetOrderRouteRepo getOrderRouteRepo;

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

	@RequestMapping(value = { "/getOrderHistoryDistwise" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrder> getOrderHistoryDistwise(@RequestParam("date") String date,
			@RequestParam("distId") int distId) {

		List<GetOrder> orderHeaderList = new ArrayList<GetOrder>();

		try {

			orderHeaderList = getOrderRepo.getOrderDist(date, distId);

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

	@RequestMapping(value = { "/getAllCatwiseItemListByDistId" }, method = RequestMethod.POST)
	public @ResponseBody GetAllCatwiseItemResp getAllCatwiseItemListByDistId(@RequestParam("distId") int distId,
			@RequestParam("hubId") int hubId) {

		List<Category> catList = new ArrayList<Category>();
		List<GetCatItemList> catItemList = new ArrayList<GetCatItemList>();
		GetAllCatwiseItemResp getAllCatwiseItemResp = new GetAllCatwiseItemResp();

		try {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sdf.format(now.getTime());

			catList = categoryRepo.findByIsUsed(1);

			List<Config> configList = configRepo.getItemConfig(hubId);
			Config config = new Config();

			for (Config c : configList) {

				if (c.getConfigType() == 3) {

					config = c;
					getAllCatwiseItemResp.setConfig(c);

				}

			}

			String itemStrList = config.getItemIds();

			List<Integer> itemIdList = Stream.of(itemStrList.split(",")).map(Integer::parseInt)
					.collect(Collectors.toList());

			Order order = null;
			System.out.println("curr date - " + currDate);
			order = orderRepo.findByOrderDateAndDistIdAndOrderType(currDate, distId, 0);

			GetOrderHeader getOrderHeader = new GetOrderHeader();

			if (order != null) {
				getOrderHeader.setDistId(distId);
				getOrderHeader.setOrderHeaderId(order.getOrderHeaderId());
				getOrderHeader.setOrderTotal(order.getOrderTotal());
				getOrderHeader.setOrderType(order.getOrderType());
				getOrderHeader.setPrevPendingAmt(order.getPrevPendingAmt());
				getOrderHeader.setPrevPendingCrateBal(order.getPrevPendingCrateBal());
			}
			getAllCatwiseItemResp.setGetOrderHeader(getOrderHeader);

			catList = categoryRepo.findByIsUsed(1);

			for (int i = 0; i < catList.size(); i++) {

				Category cat = catList.get(i);

				GetCatItemList catItem = new GetCatItemList();
				catItem.setCatEngName(cat.getCatEngName());
				catItem.setCatId(cat.getCatId());
				catItem.setCatMarName(cat.getCatMarName());
				catItem.setCatPic(cat.getCatPic());
				catItem.setIsUsed(cat.getIsUsed());

				List<GetAllItemsForRegOrder> list = getAllItemsForRegOrderRepo.getAllItemDetails(itemIdList,
						cat.getCatId());

				for (int j = 0; j < list.size(); j++) {

					GetAllItemsForRegOrder getAllItemsForRegOrder = list.get(j);
					if (order != null) {
						try {
							OrderDetail orderDetail = orderDetailRepo.findByItemIdAndOrderHeaderId(
									getAllItemsForRegOrder.getItemId(), order.getOrderHeaderId());

							list.get(j).setOrderQty(orderDetail.getOrderQty());
							list.get(j).setOrderDetailId(orderDetail.getOrderDetailId());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

				catItem.setAllItemList(list);

				catItemList.add(catItem);

			}
			System.out.println("CatItemList - " + catItemList.toString());

			getAllCatwiseItemResp.setCatItemLists(catItemList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getAllCatwiseItemResp;

	}

	@RequestMapping(value = { "/getOrderByTypeAndStatus" }, method = RequestMethod.GET)
	public @ResponseBody List<GetOrder> getOrderByTypeAndStatus() {

		List<GetOrder> orderHeaderList = new ArrayList<GetOrder>();

		try {

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sdf.format(now.getTime());

			orderHeaderList = getOrderRepo.getOrder(currDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderHeaderList;

	}

	// getOrderByHubIdStausAndType
	@RequestMapping(value = { "/getOrderByHubIdStausAndType" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrder> getOrderByHubIdStausAndType(@RequestParam("orderType") int orderType,
			@RequestParam("orderStatus") int orderStatus, @RequestParam("hubId") int hubId) {

		List<GetOrder> orderHeaderList = new ArrayList<GetOrder>();

		try {

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sdf.format(now.getTime());

			orderHeaderList = getOrderRepo.getOrderByHubIdStausAndType(currDate, orderType, orderStatus, hubId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderHeaderList;

	}

	@RequestMapping(value = { "/getOrderByOrderHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody GetOrder getOrderByOrderHeaderId(@RequestParam("orderHeaderId") int orderHeaderId) {

		GetOrder getOrder = new GetOrder();

		try {

			getOrder = getOrderRepo.getOrderByOrderHeaderid(orderHeaderId);
			List<GetOrderDetail> orderDetailList = getOrderDetailRepo.getOrderDetail(orderHeaderId);
			getOrder.setGetOrderDetailList(orderDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getOrder;

	}

	@RequestMapping(value = { "/getOrderRouteAllocation" }, method = RequestMethod.POST)
	public @ResponseBody GetRouteData getOrderRouteAllocation(@RequestParam("supervisorId") int supervisorId) {

		RouteAllocation routeAllocation = new RouteAllocation();
		Route route = new Route();
		List<Distributor> distList = new ArrayList<>();
		GetOrderRoute getOrderRoute = new GetOrderRoute();
		List<GetOrderRoute> getOrderRouteList = new ArrayList<>();
		List<GetRouteData> getRouteList = new ArrayList<>();
		GetRouteData getRoute = new GetRouteData();

		try {

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sdf.format(now.getTime());

			routeAllocation = routeAllocationRepo.getRouteAllocation(currDate, supervisorId);
			route = routeRepository.findByRouteIdAndIsUsed(routeAllocation.getRouteId(), 1);

			distList = distributorRepository.findByRouteIdAndIsUsed(route.getRouteId(), 1);
			for (int i = 0; i < distList.size(); i++) {
				getOrderRoute = new GetOrderRoute();

				getOrderRoute = getOrderRouteRepo.getOrderRoute(currDate, distList.get(i).getDistId());

				System.out.println("orderHeaderId" + getOrderRoute.getOrderHeaderId());

				List<GetOrderDetail> orderDetailList = getOrderDetailRepo
						.getOrderDetail(getOrderRoute.getOrderHeaderId());

				getOrderRoute.setGetOrderDetailList(orderDetailList);
				getOrderRouteList.add(getOrderRoute);
				getRoute.setRoute(route);
				getRoute.setGetOrderList(getOrderRouteList);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getRoute;

	}

}
