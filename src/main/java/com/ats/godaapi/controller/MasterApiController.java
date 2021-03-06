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

import com.ats.godaapi.model.CatItemList;
import com.ats.godaapi.model.Category;
import com.ats.godaapi.model.Distributor;
import com.ats.godaapi.model.Driver;
import com.ats.godaapi.model.ErrorMessage;
import com.ats.godaapi.model.GetItemName;
import com.ats.godaapi.model.GetRoute;
import com.ats.godaapi.model.Hub;
import com.ats.godaapi.model.HubUser;
import com.ats.godaapi.model.Item;
import com.ats.godaapi.model.ItemHsn;
import com.ats.godaapi.model.LoginResHubUser;
import com.ats.godaapi.model.LoginResponseDist;
import com.ats.godaapi.model.LoginResponseMU;
import com.ats.godaapi.model.LoginResponseSup;
import com.ats.godaapi.model.MahasanghUser;
import com.ats.godaapi.model.Route;
import com.ats.godaapi.model.RouteSup;
import com.ats.godaapi.model.Uom;
import com.ats.godaapi.model.Vehicle;
import com.ats.godaapi.repository.CatItemListRepo;
import com.ats.godaapi.repository.CategoryRepo;
import com.ats.godaapi.repository.DistributorRepository;
import com.ats.godaapi.repository.DriverRepo;
import com.ats.godaapi.repository.GetCatItemListRepo;
import com.ats.godaapi.repository.GetItemNameRepo;
import com.ats.godaapi.repository.GetItemRepo;
import com.ats.godaapi.repository.GetRouteRepo;
import com.ats.godaapi.repository.HubRepository;
import com.ats.godaapi.repository.HubUserRepo;
import com.ats.godaapi.repository.ItemHsnRepo;
import com.ats.godaapi.repository.ItemRepo;
import com.ats.godaapi.repository.MahasnaghUserRepo;
import com.ats.godaapi.repository.OrderRepo;
import com.ats.godaapi.repository.RouteRepository;
import com.ats.godaapi.repository.RouteSupRepo;
import com.ats.godaapi.repository.UomRepo;
import com.ats.godaapi.repository.VehicleRepo;

@RestController
public class MasterApiController {

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	HubRepository hubRepository;

	@Autowired
	VehicleRepo vehicleRepo;

	@Autowired
	GetItemNameRepo getItemNameRepo;

	@Autowired
	GetRouteRepo getRouteRepo;

	@Autowired
	GetItemRepo getItemRepo;

	@Autowired
	GetCatItemListRepo getCatItemListRepo;

	@Autowired
	UomRepo uomRepo;

	@Autowired
	CatItemListRepo catItemListRepo;

	@Autowired
	MahasnaghUserRepo mahasnaghUserRepo;

	@Autowired
	RouteSupRepo routeSupRepo;

	@Autowired
	HubUserRepo hubUserRepo;

	@Autowired
	RouteRepository routeRepository;

	@Autowired
	DistributorRepository distributorRepository;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	ItemHsnRepo itemHsnRepo;

	@Autowired
	ItemRepo itemRepo;

	@Autowired
	DriverRepo driverRepo;

	// -------------------Driver------------------------

	@RequestMapping(value = { "/saveDriver" }, method = RequestMethod.POST)
	public @ResponseBody Driver saveDriver(@RequestBody Driver driver) {

		Driver res = new Driver();

		try {

			res = driverRepo.saveAndFlush(driver);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getAllDriverByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Driver> getAllDriverByIsUsed() {

		List<Driver> driList = new ArrayList<Driver>();

		try {

			driList = driverRepo.findByIsUsedOrderByDriverIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return driList;

	}

	@RequestMapping(value = { "/getDriverByDriverId" }, method = RequestMethod.POST)
	public @ResponseBody Driver getDriverByDriverId(@RequestParam("driverId") int driverId) {

		Driver driver = null;
		try {
			driver = driverRepo.findByDriverIdAndIsUsed(driverId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return driver;

	}

	@RequestMapping(value = { "/deleteDriver" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDriver(@RequestParam("driverId") int driverId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = driverRepo.deleteDriver(driverId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------Vehicle------------------------

	@RequestMapping(value = { "/saveVehicle" }, method = RequestMethod.POST)
	public @ResponseBody Vehicle saveVehicle(@RequestBody Vehicle vehicle) {

		Vehicle res = new Vehicle();

		try {

			res = vehicleRepo.saveAndFlush(vehicle);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getAllVehByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Vehicle> getAllVehByIsUsed() {

		List<Vehicle> vehList = new ArrayList<Vehicle>();

		try {

			vehList = vehicleRepo.findByIsUsedOrderByVehicleIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vehList;

	}

	@RequestMapping(value = { "/getVehicleByVehId" }, method = RequestMethod.POST)
	public @ResponseBody Vehicle getVehicleByVehId(@RequestParam("vehicleId") int vehicleId) {

		Vehicle driver = null;
		try {
			driver = vehicleRepo.findByVehicleIdAndIsUsed(vehicleId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return driver;

	}

	@RequestMapping(value = { "/deleteVehicle" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteVehicle(@RequestParam("vehicleId") int vehicleId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = vehicleRepo.deleteVehicle(vehicleId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------UOM------------------------

	@RequestMapping(value = { "/saveUom" }, method = RequestMethod.POST)
	public @ResponseBody Uom saveUom(@RequestBody Uom uom) {

		Uom res = new Uom();

		try {

			res = uomRepo.saveAndFlush(uom);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getUomByUomId" }, method = RequestMethod.POST)
	public @ResponseBody Uom getUomByUomId(@RequestParam("uomId") int uomId) {

		Uom uom = null;
		try {
			uom = uomRepo.findByUomIdAndIsUsed(uomId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return uom;

	}

	@RequestMapping(value = { "/getAllUomByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Uom> getAllUomByIsUsed() {

		List<Uom> uomList = new ArrayList<Uom>();

		try {

			uomList = uomRepo.findByIsUsedOrderByUomIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return uomList;

	}

	@RequestMapping(value = { "/deleteUom" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteUom(@RequestParam("uomId") int uomId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = uomRepo.deleteUom(uomId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------Hub------------------------

	@RequestMapping(value = { "/saveHub" }, method = RequestMethod.POST)
	public @ResponseBody Hub saveHub(@RequestBody Hub hub) {

		Hub res = new Hub();

		try {

			res = hubRepository.saveAndFlush(hub);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getHubByHubId" }, method = RequestMethod.POST)
	public @ResponseBody Hub getHubByHubId(@RequestParam("hubId") int hubId) {

		Hub hub = null;
		try {
			hub = hubRepository.findByHubIdAndIsUsed(hubId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return hub;

	}

	@RequestMapping(value = { "/getAllHubByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Hub> getAllHubByIsUsed() {

		List<Hub> hubList = new ArrayList<Hub>();

		try {

			hubList = hubRepository.findByIsUsedOrderByHubIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return hubList;

	}
	// Search Hub by mob no or hub name for MS Dashboard 27-09-2018

	@RequestMapping(value = { "/searchHub" }, method = RequestMethod.POST)
	public @ResponseBody List<Hub> searchHub(@RequestParam("hubMobOrName") String hubMobOrName) {

		List<Hub> hubList = new ArrayList<Hub>();

		try {

			hubList = hubRepository.findByHubContactNoOrHubEngNameIgnoreCaseContainingAndIsUsed(hubMobOrName,
					hubMobOrName, 1);

		} catch (Exception e) {

			System.err.println("Exception in getting hub bys earchHub" + e.getMessage());

			e.printStackTrace();

		}
		return hubList;

	}

	@RequestMapping(value = { "/deleteHub" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteHub(@RequestParam("hubId") int hubId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = hubRepository.deleteHub(hubId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------Route------------------------

	@RequestMapping(value = { "/saveRoute" }, method = RequestMethod.POST)
	public @ResponseBody Route saveRoute(@RequestBody Route route) {

		Route res = new Route();

		try {

			res = routeRepository.saveAndFlush(route);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getRouteByRouteId" }, method = RequestMethod.POST)
	public @ResponseBody Route getRouteByRouteId(@RequestParam("routeId") int routeId) {

		Route route = null;
		try {
			route = routeRepository.findByRouteIdAndIsUsed(routeId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return route;

	}

	@RequestMapping(value = { "/getAllRouteByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Route> getAllRouteByIsUsed() {

		List<Route> routeList = new ArrayList<Route>();

		try {

			routeList = routeRepository.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return routeList;

	}

	@RequestMapping(value = { "/getAllGetRouteByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<GetRoute> getAllGetRouteByIsUsed() {

		List<GetRoute> routeList = new ArrayList<GetRoute>();

		try {

			routeList = getRouteRepo.getRouteHubName();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return routeList;

	}

	@RequestMapping(value = { "/deleteRoute" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRoute(@RequestParam("routeId") int routeId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = routeRepository.deleteRoute(routeId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------Distributor------------------------

	@RequestMapping(value = { "/saveDist" }, method = RequestMethod.POST)
	public @ResponseBody Distributor saveDist(@RequestBody Distributor distributor) {

		Distributor res = new Distributor();

		try {

			res = distributorRepository.saveAndFlush(distributor);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getDistributorByDistId" }, method = RequestMethod.POST)
	public @ResponseBody Distributor getDistributorByDistId(@RequestParam("distId") int distId) {

		Distributor distributor = null;
		try {
			distributor = distributorRepository.findByDistIdAndIsUsed(distId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return distributor;

	}

	// Sachin 24/09
	@RequestMapping(value = { "/getDistributorByMobNoOrName" }, method = RequestMethod.POST)
	public @ResponseBody List<Distributor> getDistributorByMobNoOrName(
			@RequestParam("distMobOrName") String distMobOrName) {

		List<Distributor> distributorList = new ArrayList<Distributor>();

		try {

			distributorList = distributorRepository
					.findByDistContactNoOrDistEngNameIgnoreCaseContainingAndIsUsed(distMobOrName, distMobOrName, 1);

			if (distributorList.size() > 0)
				System.err.println("getDistributorByMobNoOrName" + distributorList.toString());

		} catch (Exception e) {

			System.err.println("exception In getDistributorByMobNoOrName" + e.getMessage());

			e.printStackTrace();

		}

		return distributorList;

	}

	@RequestMapping(value = { "/getDistributorByRouteId" }, method = RequestMethod.POST)
	public @ResponseBody List<Distributor> getDistributorByRouteId(@RequestParam("routeId") int routeId) {

		List<Distributor> distList = new ArrayList<>();
		try {
			distList = distributorRepository.findByRouteIdAndIsUsed(routeId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return distList;

	}

	@RequestMapping(value = { "/getAllDistByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Distributor> getAllDistByIsUsed() {

		List<Distributor> distList = new ArrayList<Distributor>();

		try {

			distList = distributorRepository.findByIsUsedOrderByDistIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return distList;

	}

	@RequestMapping(value = { "/deleteDistributor" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDistributor(@RequestParam("distId") int distId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = distributorRepository.deleteDistributor(distId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/blockDistributor" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage blockDistributor(@RequestParam("distId") int distId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = distributorRepository.blockDistributor(distId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/updatePasswordDist" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseDist updatePasswordDist(@RequestParam("distId") int distId,
			@RequestParam("distPwd") String distPwd) {

		LoginResponseDist errorMessage = new LoginResponseDist();

		try {
			int dist = distributorRepository.updatePwd(distId, distPwd);
			Distributor distributor = distributorRepository.findByDistIdAndIsUsed(distId, 1);

			if (dist == 1) {

				errorMessage.setError(false);
				errorMessage.setMsg("update Successfully");

				errorMessage.setDistributor(distributor);

			} else {
				errorMessage.setError(true);
				errorMessage.setMsg("update Failed");

			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("update Failed :EXC");

		}
		return errorMessage;
	}
	// -------------------Category------------------------

	@RequestMapping(value = { "/saveCat" }, method = RequestMethod.POST)
	public @ResponseBody Category saveCat(@RequestBody Category category) {

		Category res = new Category();

		try {

			res = categoryRepo.saveAndFlush(category);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getCatByCatId" }, method = RequestMethod.POST)
	public @ResponseBody Category getCatByCatId(@RequestParam("catId") int catId) {

		Category category = null;
		try {
			category = categoryRepo.findByCatIdAndIsUsed(catId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return category;

	}

	@RequestMapping(value = { "/getAllCatByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCatByIsUsed() {

		List<Category> catList = new ArrayList<Category>();

		try {

			catList = categoryRepo.findByIsUsedOrderByCatIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return catList;

	}

	@RequestMapping(value = { "/deleteCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteCategory(@RequestParam("catId") int catId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = categoryRepo.deleteCategory(catId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------HubUser------------------------

	@RequestMapping(value = { "/saveHubUser" }, method = RequestMethod.POST)
	public @ResponseBody HubUser saveHubUser(@RequestBody HubUser hubUser) {

		HubUser res = new HubUser();

		try {

			res = hubUserRepo.saveAndFlush(hubUser);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getAllHubUserByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<HubUser> getAllHubUserByIsUsed() {

		List<HubUser> hubUserList = new ArrayList<HubUser>();

		try {

			hubUserList = hubUserRepo.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return hubUserList;

	}

	@RequestMapping(value = { "/getHubUserByUserType" }, method = RequestMethod.POST)
	public @ResponseBody List<HubUser> getHubUserByUserType(@RequestParam("userType") List<Integer> userType) {

		List<HubUser> hubUserList = new ArrayList<HubUser>();

		try {

			hubUserList = hubUserRepo.getHubUserByUserType(userType);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return hubUserList;

	}

	@RequestMapping(value = { "/getHubUserByHsId" }, method = RequestMethod.POST)
	public @ResponseBody HubUser getHubUserByHsId(@RequestParam("hsId") int hsId) {

		HubUser hubUser = null;
		try {
			hubUser = hubUserRepo.findByHsIdAndIsUsed(hsId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return hubUser;

	}

	@RequestMapping(value = { "/deleteHubUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteHubUser(@RequestParam("hsId") int hsId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = hubUserRepo.deleteHubUser(hsId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/blockHubUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage blockHubUser(@RequestParam("hsId") int hsId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = hubUserRepo.blockHubUser(hsId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Block Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Block Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Block Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------ItemHsn------------------------

	@RequestMapping(value = { "/saveItemHsn" }, method = RequestMethod.POST)
	public @ResponseBody ItemHsn saveItemHsn(@RequestBody ItemHsn itemHsn) {

		ItemHsn res = new ItemHsn();

		try {

			res = itemHsnRepo.saveAndFlush(itemHsn);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getItemHsnByItemHsnId" }, method = RequestMethod.POST)
	public @ResponseBody ItemHsn getItemHsnByItemHsnId(@RequestParam("itemHsnId") int itemHsnId) {

		ItemHsn itemHsn = null;
		try {
			itemHsn = itemHsnRepo.findByItemHsnIdAndIsUsed(itemHsnId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemHsn;

	}

	@RequestMapping(value = { "/getAllItemHsnByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<ItemHsn> getAllItemHsnByIsUsed() {

		List<ItemHsn> itemHsnList = new ArrayList<ItemHsn>();

		try {

			itemHsnList = itemHsnRepo.findByIsUsedOrderByItemHsnIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemHsnList;

	}

	@RequestMapping(value = { "/deleteItemHsn" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteItemHsn(@RequestParam("itemHsnId") int itemHsnId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = itemHsnRepo.deleteItemHsn(itemHsnId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------Item----------------------------------

	@RequestMapping(value = { "/saveItem" }, method = RequestMethod.POST)
	public @ResponseBody Item saveItem(@RequestBody Item item) {

		Item res = new Item();

		try {

			res = itemRepo.saveAndFlush(item);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getAllItemByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Item> getAllItemByIsUsed() {

		List<Item> itemList = new ArrayList<Item>();

		try {

			itemList = itemRepo.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/getAllItem" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItemName> getAllItem() {

		List<GetItemName> itemList = new ArrayList<GetItemName>();

		try {

			itemList = getItemNameRepo.getItemName();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/getItemByItemId" }, method = RequestMethod.POST)
	public @ResponseBody Item getItemByItemId(@RequestParam("itemId") int itemId) {

		Item item = null;
		try {
			item = itemRepo.findByItemIdAndIsUsed(itemId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return item;

	}

	@RequestMapping(value = { "/getItemByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemByCatId(@RequestParam("catId") int catId) {

		List<Item> itemList = new ArrayList<Item>();
		try {
			itemList = itemRepo.findByCatIdAndIsUsed(catId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/deleteItem" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteItem(@RequestParam("itemId") int itemId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = itemRepo.deleteItem(itemId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------MahasnaghUser----------------------------------

	@RequestMapping(value = { "/saveMahasnaghUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveMahasnaghUser(@RequestBody MahasanghUser mahasnaghUser) {
		ErrorMessage errorMessage = new ErrorMessage();
		MahasanghUser res = new MahasanghUser();

		try {

			res = mahasnaghUserRepo.saveAndFlush(mahasnaghUser);
			errorMessage.setError(false);
			errorMessage.setMessage("Save Successfully");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Save Failed");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/getAllMSByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<MahasanghUser> getAllMSByIsUsed() {

		List<MahasanghUser> msList = new ArrayList<MahasanghUser>();

		try {

			msList = mahasnaghUserRepo.findByIsUsedOrderByMsIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return msList;

	}

	@RequestMapping(value = { "/getMsByMsId" }, method = RequestMethod.POST)
	public @ResponseBody MahasanghUser getMsByMsId(@RequestParam("msId") int msId) {

		MahasanghUser ms = null;
		try {
			ms = mahasnaghUserRepo.findByMsIdAndIsUsed(msId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return ms;

	}

	@RequestMapping(value = { "/deleteMahasanghUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteMahasanghUser(@RequestParam("msId") int msId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = mahasnaghUserRepo.deleteMahasnaghUser(msId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/blockMahasnaghUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage blockMahasnaghUser(@RequestParam("msId") int msId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = mahasnaghUserRepo.blockMahasnaghUser(msId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}
	// -------------------RouteSup----------------------------------

	@RequestMapping(value = { "/saveRouteSup" }, method = RequestMethod.POST)
	public @ResponseBody RouteSup saveRouteSup(@RequestBody RouteSup routeSup) {

		RouteSup res = new RouteSup();

		try {

			res = routeSupRepo.saveAndFlush(routeSup);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getAllRsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<RouteSup> getAllRsByIsUsed() {

		List<RouteSup> rsList = new ArrayList<RouteSup>();

		try {

			rsList = routeSupRepo.findByIsUsedOrderBySupIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rsList;

	}

	@RequestMapping(value = { "/getRsBySupId" }, method = RequestMethod.POST)
	public @ResponseBody RouteSup getRsBySupId(@RequestParam("supId") int supId) {

		RouteSup rs = null;
		try {
			rs = routeSupRepo.findBySupIdAndIsUsed(supId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rs;

	}

	@RequestMapping(value = { "/deleteRouteSup" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRouteSup(@RequestParam("supId") int supId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = routeSupRepo.deleteRouteSup(supId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/blockRouteSup" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage blockRouteSup(@RequestParam("supId") int supId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = routeSupRepo.blockRouteSup(supId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}
	// -----------Distributor Login--------------------

	@RequestMapping(value = { "/loginResponseDist" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseDist loginResponseDist(@RequestParam("distContactNo") String distContactNo,
			@RequestParam("distPwd") String distPwd) {

		LoginResponseDist loginResponse = new LoginResponseDist();
		try {

			Distributor dist = distributorRepository.findByDistContactNoAndDistPwdAndIsUsed(distContactNo, distPwd, 1);
			if (dist == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setDistributor(dist);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}
	// ------------Update dist token--------------

	@RequestMapping(value = { "/updateDistToken" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseDist updateDistToken(@RequestParam("distId") int distId,
			@RequestParam("token") String token) {

		Distributor dist = distributorRepository.findByDistId(distId);

		LoginResponseDist loginResponse = new LoginResponseDist();

		if (dist == null) {
			dist = new Distributor();
			loginResponse.setDistributor(dist);

			loginResponse.setError(true);
			loginResponse.setMsg("Invalid ID ");

		} else {

			loginResponse.setDistributor(dist);
			loginResponse.setError(false);
			loginResponse.setMsg("Update Token Successfully");

			int isUpdated = distributorRepository.updateToken(dist.getDistId(), token);

		}
		return loginResponse;
	}

	// -----------Supervisor Login--------------------

	@RequestMapping(value = { "/loginResponseSup" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseSup loginResponseSup(@RequestParam("supContactNo") String supContactNo,
			@RequestParam("supPwd") String supPwd) {

		LoginResponseSup loginResponse = new LoginResponseSup();
		try {

			RouteSup rs = routeSupRepo.findBySupContactNoAndSupPwdAndIsUsed(supContactNo, supPwd, 1);
			if (rs == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setRouteSup(rs);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	@RequestMapping(value = { "/getAllCatwiseItemList" }, method = RequestMethod.GET)
	public @ResponseBody List<CatItemList> getAllCatwiseItemList() {

		List<Category> catList = new ArrayList<Category>();
		List<CatItemList> catItemList = new ArrayList<CatItemList>();

		try {

			catList = categoryRepo.findByIsUsed(1);

			for (int i = 0; i < catList.size(); i++) {

				Category cat = catList.get(i);

				CatItemList catItem = new CatItemList();
				catItem.setCatEngName(cat.getCatEngName());
				catItem.setCatId(cat.getCatId());
				catItem.setCatMarName(cat.getCatMarName());
				catItem.setCatPic(cat.getCatPic());
				catItem.setIsUsed(cat.getIsUsed());

				List<Item> itemList = itemRepo.findByCatId(cat.getCatId());

				catItem.setItemList(itemList);

				catItemList.add(catItem);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return catItemList;

	}

	// ----------------Hub user login---------------

	@RequestMapping(value = { "/loginResponseHubUser" }, method = RequestMethod.POST)
	public @ResponseBody LoginResHubUser loginResponseHubUser(@RequestParam("hsContactNo") String hsContactNo,
			@RequestParam("hsPwd") String hsPwd) {

		LoginResHubUser loginResponse = new LoginResHubUser();
		try {

			HubUser hb = hubUserRepo.findByHsContactNoAndHsPwdAndIsUsed(hsContactNo, hsPwd, 1);
			if (hb == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setHubUser(hb);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	// -------------Add new staff member==Hub User-------------

	@RequestMapping(value = { "/saveHubUserExisting" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveHubUserExisting(@RequestBody HubUser hubUser) {
		ErrorMessage errorMessage = new ErrorMessage();
		HubUser res = new HubUser();
		try {
			if (hubUser.getHsId() == 0) {

				res = hubUserRepo.findByHsContactNoAndIsUsed(hubUser.getHsContactNo(), 1);

				if (res == null) {

					res = hubUserRepo.saveAndFlush(hubUser);
					errorMessage.setError(false);
					errorMessage.setMessage("Save Successfully");

				} else {
					errorMessage.setError(true);
					errorMessage.setMessage("Mobile No Already Exist");
				}
			} else {
				res = hubUserRepo.saveAndFlush(hubUser);
				errorMessage.setError(false);
				errorMessage.setMessage("Update  Successfully");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return errorMessage;
	}

	// -----------Mahasangh user Login--------------------

	@RequestMapping(value = { "/loginResponseMah" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseMU loginResponseMah(@RequestParam("msContactNo") String msContactNo,
			@RequestParam("msPwd") String msPwd) {

		LoginResponseMU loginResponse = new LoginResponseMU();
		try {

			MahasanghUser mu = mahasnaghUserRepo.findByMsContactNoAndMsPwdAndIsUsed(msContactNo, msPwd, 1);
			if (mu == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setMahasnaghUser(mu);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	// -------------Add new staff member==MahasnaghUser -------------

	@RequestMapping(value = { "/saveMahasanghUserExisting" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveMahasanghUserExisting(@RequestBody MahasanghUser mahasnaghUser) {
		ErrorMessage errorMessage = new ErrorMessage();
		MahasanghUser res = new MahasanghUser();
		try {
			if (mahasnaghUser.getMsId() == 0) {
				res = mahasnaghUserRepo.findByMsContactNoAndIsUsed(mahasnaghUser.getMsContactNo(), 1);

				if (res == null) {

					res = mahasnaghUserRepo.saveAndFlush(mahasnaghUser);
					errorMessage.setError(false);
					errorMessage.setMessage("Save Successfully");

				} else {
					errorMessage.setError(true);
					errorMessage.setMessage("Mobile No Already Exist");
				}
			} else {
				res = mahasnaghUserRepo.saveAndFlush(mahasnaghUser);
				errorMessage.setError(false);
				errorMessage.setMessage("Update  Successfully");

			}

		} catch (

		Exception e) {

			e.printStackTrace();

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/saveDistributorExisting" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveDistributorExisting(@RequestBody Distributor distributor) {
		ErrorMessage errorMessage = new ErrorMessage();
		Distributor res = new Distributor();
		try {

			if (distributor.getDistId() == 0) {
				res = distributorRepository.findByDistContactNoAndIsUsed(distributor.getDistContactNo(), 1);

				if (res == null) {

					res = distributorRepository.saveAndFlush(distributor);
					errorMessage.setError(false);
					errorMessage.setMessage("Save Successfully");

				} else {
					errorMessage.setError(true);
					errorMessage.setMessage("Mobile No Already Exist");
				}
			} else {
				res = distributorRepository.saveAndFlush(distributor);
				errorMessage.setError(false);
				errorMessage.setMessage("Update Successfully");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return errorMessage;
	}
	// -------------Add new Route Supervisor==Route Supervisor -------------

	@RequestMapping(value = { "/saveRouteSuperVisorExisting" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveRouteSuperVisorExisting(@RequestBody RouteSup routeSup) {
		ErrorMessage errorMessage = new ErrorMessage();
		RouteSup res = new RouteSup();
		try {
			if (routeSup.getSupId() == 0) {
				res = routeSupRepo.findBySupContactNoAndIsUsed(routeSup.getSupContactNo(), 1);

				if (res == null) {

					res = routeSupRepo.saveAndFlush(routeSup);
					errorMessage.setError(false);
					errorMessage.setMessage("Save Successfully");

				} else {
					errorMessage.setError(true);
					errorMessage.setMessage("Mobile No Already Exist");
				}
			} else {
				res = routeSupRepo.saveAndFlush(routeSup);
				errorMessage.setError(false);
				errorMessage.setMessage("Update Successfully");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return errorMessage;
	}

	// Sachin Update Order Header Status for Production
	// updateOrderStatus

	@RequestMapping(value = { "/updateOrderStatus" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateOrderStatusMethod(
			@RequestParam("orderHeaderList") List<Integer> orderHeaderList,
			@RequestParam("orderStatus") int orderStatus) {

		ErrorMessage errorMessage = new ErrorMessage();

		int res;

		try {

			res = orderRepo.updateOrderHeadStatus(orderStatus, orderHeaderList);

			if (res > 0) {

				errorMessage.setError(false);
				errorMessage.setMessage("success Update Order Header");

			}

		} catch (Exception e) {

			System.err.println("exc in update order " + e.getMessage());
			e.printStackTrace();
			errorMessage.setError(true);

		}

		return errorMessage;
	}

}
