package com.org.coop.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.coop.service.LoginService;

@RestController
@RequestMapping("/rest")
public class TestController {
	private static final Logger log = Logger.getLogger(TestController.class); 
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/person")
	@PreAuthorize("hasRole('ROLE_USER')")
	public void getPersonDetail(@RequestParam(value = "id",required = false,
	                                                    defaultValue = "0") Integer id) {
		List<String> role = loginService.getRole("ashish");
		log.debug("ROLE: " + role);
	}
	
//	@RequestMapping("/verifyOTP")
//	public void verifyOTP(@RequestParam(value = "otp",required = true) String otp) {
//		System.out.println("OTP: " + otp);
//	}

}
