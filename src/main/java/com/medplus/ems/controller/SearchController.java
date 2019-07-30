package com.medplus.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeSearchCriteria;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.impl.UserServiceImpl;


@RestController
public class SearchController {
	
	@Autowired
	EmployeeSearchCriteria emp;
	@Autowired
	UserServiceImpl userServiceImpl;
	@RequestMapping(value = "/empsearch", method = RequestMethod.POST)	
	public @ResponseBody ModelMap searchEmployee(@RequestBody String empsearch) {
		ModelMap ss = new ModelMap();
		try {
			EmployeeSearchCriteria emp = new Gson().fromJson(empsearch, EmployeeSearchCriteria.class);
			List<EmployeeDetails> list = userServiceImpl.getEmployeeDetails(emp);
			ss.put("values", list);
		} catch (EMSException e) {
			ss.put("msg", e.getMessage());
		}
		return ss;
	}
	
//	@RequestMapping(value = "/empsearch", method = RequestMethod.GET)
//	public void searchEmployee() {
//		System.out.println("hello");
//	}
}