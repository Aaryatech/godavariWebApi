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

import com.ats.godaapi.common.Firebase;
import com.ats.godaapi.model.Config;
import com.ats.godaapi.model.Distributor;
import com.ats.godaapi.model.ErrorMessage;
import com.ats.godaapi.model.GetNotification;
import com.ats.godaapi.model.GetNotificationRoute;
import com.ats.godaapi.model.GetSetting;
import com.ats.godaapi.model.Notification;
import com.ats.godaapi.model.RouteAllocation;
import com.ats.godaapi.model.RouteSup;
import com.ats.godaapi.model.Setting;
import com.ats.godaapi.model.Test;
import com.ats.godaapi.repository.ConfigRepo;
import com.ats.godaapi.repository.DistributorRepository;
import com.ats.godaapi.repository.GetSettingRepo;
import com.ats.godaapi.repository.NotifiRepo;
import com.ats.godaapi.repository.RouteAllocationRepo;
import com.ats.godaapi.repository.RouteRepository;
import com.ats.godaapi.repository.RouteSupRepo;
import com.ats.godaapi.repository.SettingRepo;
import com.ats.godaapi.repository.TestRepo;

@RestController
public class TxApiController {

	@Autowired
	SettingRepo settingRepo;

	@Autowired
	RouteAllocationRepo routeAllocationRepo;

	@Autowired
	ConfigRepo configRepo;

	@Autowired
	TestRepo testRepo;

	@Autowired
	NotifiRepo notifiRepo;

	@Autowired
	RouteRepository routeRepository;

	@Autowired
	DistributorRepository distributorRepository;

	@Autowired
	GetSettingRepo getSettingRepo;
	@Autowired
	RouteSupRepo routeSupRepo;

	@RequestMapping(value = { "/saveNotificationByRouteId" }, method = RequestMethod.POST)
	public @ResponseBody GetNotificationRoute saveNotificationByRouteId(@RequestBody GetNotificationRoute noti) {

		Notification notObejct = new Notification();
		List<Distributor> dist = new ArrayList<Distributor>();

		try {

			dist = distributorRepository.findByRouteIdAndIsUsed(noti.getRouteId(), 1);
			System.err.println("dist List Size : by route Id and is used  = " + dist.size());

			for (int j = 0; j < dist.size(); j++) {

				System.out.println("in for : dist[j=]" + j);

				notObejct = new Notification();

				notObejct.setNotifiTo(dist.get(j).getDistId());
				notObejct.setIsRead(noti.getNotification().getIsRead());
				notObejct.setNotifiDate(noti.getNotification().getNotifiDate());
				notObejct.setNotifiDatetime(noti.getNotification().getNotifiDatetime());
				notObejct.setNotifiFrom(noti.getNotification().getNotifiFrom());
				notObejct.setNotifiId(noti.getNotification().getNotifiId());
				notObejct.setNotifiText(noti.getNotification().getNotifiText());
				notObejct.setNotifiType(noti.getNotification().getNotifiType());

				Notification insetRes = notifiRepo.saveAndFlush(notObejct);

				System.out.println("insetRes------------------===" + insetRes.toString());

				Firebase.sendPushNotification(dist.get(j).getToken(), " Notification",
						noti.getNotification().getNotifiText(), 2);
			}

		} catch (Exception e) {

			System.err.println("exception in saveNotificationByRouteId : @tx api  " + e.getMessage());

			e.printStackTrace();

		}
		return noti;
	}

	@RequestMapping(value = { "/saveNotiByDistIdList" }, method = RequestMethod.POST)
	public @ResponseBody GetNotification saveNotiByDistIdList(@RequestBody GetNotification noti) {
		System.err.println(" inside saveNotifiByDistIdList ");
		GetNotification getNotif = new GetNotification();
		Notification notObejct = new Notification();
		List<Distributor> dist = new ArrayList<>();

		try {

			if (noti.getDistIdList().contains(-1)) {

				dist = distributorRepository.findByIsUsed(1);

				for (int j = 0; j < dist.size(); j++) {

					notObejct = new Notification();

					notObejct.setNotifiTo(dist.get(j).getDistId());
					notObejct.setIsRead(noti.getNotification().getIsRead());
					notObejct.setNotifiDate(noti.getNotification().getNotifiDate());
					notObejct.setNotifiDatetime(noti.getNotification().getNotifiDatetime());
					notObejct.setNotifiFrom(noti.getNotification().getNotifiFrom());
					notObejct.setNotifiId(noti.getNotification().getNotifiId());
					notObejct.setNotifiText(noti.getNotification().getNotifiText());
					notObejct.setNotifiType(noti.getNotification().getNotifiType());

					Notification insetRes = notifiRepo.saveAndFlush(notObejct);
					Firebase.sendPushNotification(dist.get(j).getToken(), " Notification",
							noti.getNotification().getNotifiText(), 2);

				}
			} else {
				dist = distributorRepository.getDistListById(noti.getDistIdList());

				for (int j = 0; j < noti.getDistIdList().size(); j++) {

					notObejct = new Notification();

					notObejct.setNotifiTo(noti.getDistIdList().get(j));
					notObejct.setIsRead(noti.getNotification().getIsRead());
					notObejct.setNotifiDate(noti.getNotification().getNotifiDate());
					notObejct.setNotifiDatetime(noti.getNotification().getNotifiDatetime());
					notObejct.setNotifiFrom(noti.getNotification().getNotifiFrom());
					notObejct.setNotifiId(noti.getNotification().getNotifiId());
					notObejct.setNotifiText(noti.getNotification().getNotifiText());
					notObejct.setNotifiType(noti.getNotification().getNotifiType());

					Notification insetRes = notifiRepo.saveAndFlush(notObejct);
					Firebase.sendPushNotification(dist.get(j).getToken(), " Notification",
							noti.getNotification().getNotifiText(), 2);

				}
			}

		} catch (Exception e) {

			System.err.println("Excption in Save Noti by Dist Ids " + e.getMessage());

			e.printStackTrace();

		}
		return getNotif;
	}

	// -------------------RouteAllocation------------------------

	@RequestMapping(value = { "/saveRouteAllocation" }, method = RequestMethod.POST)
	public @ResponseBody RouteAllocation saveRouteAllocation(@RequestBody RouteAllocation routeAllocation) {

		RouteAllocation res = new RouteAllocation();

		try {

			res = routeAllocationRepo.saveAndFlush(routeAllocation);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getAllRouteAllocation" }, method = RequestMethod.GET)
	public @ResponseBody List<RouteAllocation> getAllRouteAllocation() {

		List<RouteAllocation> rtList = new ArrayList<RouteAllocation>();

		try {

			rtList = routeAllocationRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rtList;

	}

	@RequestMapping(value = { "/getRouteAllocationByTrId" }, method = RequestMethod.POST)
	public @ResponseBody RouteAllocation getRouteAllocationByTrId(@RequestParam("trId") int trId) {

		RouteAllocation ra = null;
		try {
			ra = routeAllocationRepo.findByTrId(trId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return ra;

	}

	// -------------------Test------------------------

	@RequestMapping(value = { "/saveTest" }, method = RequestMethod.POST)
	public @ResponseBody Test saveTest(@RequestBody Test test) {

		System.out.println("Input param " + test.toString());
		Test res = new Test();

		try {

			res = testRepo.saveAndFlush(test);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getAllTests" }, method = RequestMethod.GET)
	public @ResponseBody List<Test> getAllTests() {

		List<Test> testList = new ArrayList<Test>();

		try {

			testList = testRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return testList;

	}

	// -------------------Setting------------------------

	@RequestMapping(value = { "/saveSetting" }, method = RequestMethod.POST)
	public @ResponseBody Setting saveSetting(@RequestBody Setting setting) {

		Setting res = new Setting();

		try {

			res = settingRepo.saveAndFlush(setting);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/saveSettingList" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveSettingList(@RequestBody List<Setting> settingList) {
		ErrorMessage errorMessage = new ErrorMessage();

		try {

			for (int i = 0; i < settingList.size(); i++) {

				int isDailyExist = 0;

				List<Config> configList = configRepo.getItemConfig(settingList.get(i).getHubId());

				for (int j = 0; j < configList.size(); j++) {

					if (configList.get(j).getConfigType() == 3) {

						isDailyExist = 1;
						System.err.println("is daily exist =1 don't call insert");

						break;
					}

				}
				if (isDailyExist == 0) {
					System.err.println("is daily exist =0 Call Insert ->saveSettingList");

					Setting res = settingRepo.save(settingList.get(i));
				}
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

	@RequestMapping(value = { "/getSettingBySettingId" }, method = RequestMethod.POST)
	public @ResponseBody Setting getSettingBySettingId(@RequestParam("settingId") int settingId) {

		Setting set = null;
		try {
			set = settingRepo.findBySettingIdAndIsUsed(settingId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return set;

	}

	@RequestMapping(value = { "/getAllSettingByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Setting> getAllSettingByIsUsed() {

		List<Setting> setList = new ArrayList<Setting>();

		try {

			setList = settingRepo.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return setList;

	}

	@RequestMapping(value = { "/deleteSetting" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSetting(@RequestParam("settingId") int settingId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = settingRepo.deleteSetting(settingId);

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

	// -------------------Config------------------------

	@RequestMapping(value = { "/saveConfig" }, method = RequestMethod.POST)
	public @ResponseBody Config saveConfig(@RequestBody Config config) {

		Config res = new Config();

		try {

			res = configRepo.saveAndFlush(config);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getAllConfigByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Config> getAllConfigByIsUsed() {

		List<Config> conList = new ArrayList<Config>();

		try {

			conList = configRepo.findByIsUsedOrderByConfigIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/getConfigByConfigId" }, method = RequestMethod.POST)
	public @ResponseBody Config getConfigByConfigId(@RequestParam("configId") int configId) {

		Config con = null;
		try {
			con = configRepo.findByConfigIdAndIsUsed(configId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return con;

	}

	@RequestMapping(value = { "/deleteConfig" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteConfig(@RequestParam("configId") int configId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = configRepo.deleteConfig(configId);

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

	// ------------------------Notification----------

	@RequestMapping(value = { "/saveNotifi" }, method = RequestMethod.POST)
	public @ResponseBody Notification saveNotifi(@RequestBody Notification noti) {

		Notification res = new Notification();

		try {

			res = notifiRepo.saveAndFlush(noti);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/saveNotifiList" }, method = RequestMethod.POST)
	public @ResponseBody List<Notification> saveNotifiList(@RequestBody List<Notification> noti) {

		List<Notification> res = new ArrayList<Notification>();

		try {

			RouteSup routeSup = new RouteSup();

			res = notifiRepo.saveAll(noti);

			for (int i = 0; i < res.size(); i++) {
				if (noti.get(i).getNotifiType() == 0) {
					routeSup = routeSupRepo.findBySupIdAndIsUsed(noti.get(i).getNotifiTo(), 1);

					Firebase.sendPushNotification(routeSup.getToken(), " Notification", noti.get(i).getNotifiText(), 2);

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

	@RequestMapping(value = { "/getAllNotiById" }, method = RequestMethod.POST)
	public @ResponseBody List<Notification> getAllNotiById(@RequestParam("notifiTo") int notifiTo,
			@RequestParam("notifiType") int notifiType, @RequestParam("isRead") int isRead) {

		List<Notification> notiList = new ArrayList<Notification>();

		try {
			notiList = notifiRepo.findByNotifiToAndNotifiTypeAndIsRead(notifiTo, notifiType, isRead);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return notiList;

	}

	@RequestMapping(value = { "/getNotiByNotifiId" }, method = RequestMethod.POST)
	public @ResponseBody Notification getNotiByNotifiId(@RequestParam("notifiId") int notifiId) {

		Notification noti = null;
		try {
			noti = notifiRepo.findByNotifiId(notifiId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return noti;

	}

	@RequestMapping(value = { "/getNotiByDistId" }, method = RequestMethod.POST)
	public @ResponseBody List<Notification> getNotiByDistId(@RequestParam("notifiTo") int notifiTo) {

		List<Notification> noti = new ArrayList<>();
		try {
			noti = notifiRepo.findByNotifiToAndNotifiTypeOrderByNotifiIdDesc(notifiTo, 2);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return noti;

	}

	@RequestMapping(value = { "/getNotiByRouteSupId" }, method = RequestMethod.POST)
	public @ResponseBody List<Notification> getNotiByRouteSupId(@RequestParam("notifiTo") int notifiTo) {

		List<Notification> noti = new ArrayList<>();
		try {
			noti = notifiRepo.findByNotifiToAndNotifiTypeOrderByNotifiIdDesc(notifiTo, 0);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return noti;

	}

	@RequestMapping(value = { "/getAllNotiFications" }, method = RequestMethod.GET)
	public @ResponseBody List<Notification> getAllNotiFications() {

		List<Notification> notiList = new ArrayList<Notification>();

		try {

			notiList = notifiRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return notiList;

	}

	@RequestMapping(value = { "/updateRead" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateRead(@RequestParam("notifiId") int notifiId,
			@RequestParam("isRead") int isRead) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = notifiRepo.updateRead(notifiId, isRead);

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
			errorMessage.setMessage("Update Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/getNotiForHubByHubId" }, method = RequestMethod.POST)
	public @ResponseBody List<Notification> getNotiForHubByHubId(@RequestParam("notifiTo") int notifiTo) {

		List<Notification> notiList = new ArrayList<Notification>();

		try {
			notiList = notifiRepo.findByNotifiToAndNotifiTypeOrderByNotifiIdDesc(notifiTo, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return notiList;

	}

	@RequestMapping(value = { "/getNotiByNotifiType" }, method = RequestMethod.POST)
	public @ResponseBody List<Notification> getNotiByNotifiType(@RequestParam("notifiType") List<Integer> notifiType) {

		List<Notification> notiList = new ArrayList<Notification>();

		try {
			notiList = notifiRepo.findByNotifiType(notifiType);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return notiList;

	}

	@RequestMapping(value = { "/getSettingHubName" }, method = RequestMethod.GET)
	public @ResponseBody List<GetSetting> getSettingHubName() {

		List<GetSetting> setList = new ArrayList<GetSetting>();

		try {

			setList = getSettingRepo.getSetting();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return setList;

	}

}
