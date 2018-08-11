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

import com.ats.godaapi.model.Config;
import com.ats.godaapi.model.ErrorMessage;
import com.ats.godaapi.model.Setting;
import com.ats.godaapi.model.Test;
import com.ats.godaapi.repository.ConfigRepo;
import com.ats.godaapi.repository.SettingRepo;
import com.ats.godaapi.repository.TestRepo;

@RestController
public class TxApiController {

	@Autowired
	SettingRepo settingRepo;

	@Autowired
	ConfigRepo configRepo;

	@Autowired
	TestRepo testRepo;

	// -------------------Test------------------------

	@RequestMapping(value = { "/saveTest" }, method = RequestMethod.POST)
	public @ResponseBody Test saveTest(@RequestBody Test test) {

		
		System.out.println("Input param "+test.toString());
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

			conList = configRepo.findByIsUsed(1);

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

}
