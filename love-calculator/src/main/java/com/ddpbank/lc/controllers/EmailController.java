package com.ddpbank.lc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ddbbank.lc.api.EmailDTO;
import com.ddbbank.lc.api.LoginInfoDTO;
import com.ddpbank.lc.services.LCAppEmailServiceImpl;

@Controller
public class EmailController {

	@Autowired
	LCAppEmailServiceImpl lCAppEmailServiceImpl;
	
	@RequestMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("sendEmail") EmailDTO emailDto) {
		return "send-Email-page";
	}

	@RequestMapping("/validateEmail")
	public String validateEmail(@SessionAttribute("loginInfo") LoginInfoDTO loginInfoDto, @ModelAttribute("sendEmail") EmailDTO emailDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String resulty = (String)session.getAttribute("appResult");
		lCAppEmailServiceImpl.sendEmail(loginInfoDto.getYourName(), emailDto.getEmailBox(), resulty);
		return "validate-Email-page";
	}

}
