package com.ddpbank.lc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ddbbank.lc.api.LoginInfoDTO;
import com.ddpbank.lc.services.EnemyCalculatorResult;

@Controller
@SessionAttributes("loginInfo")
public class LoginAppController {

	@Autowired
	EnemyCalculatorResult calcuResults;
	
	@RequestMapping("/")
	public String loginPage(Model model)
	{
		System.out.println("Inside Login page controller");
		model.addAttribute("loginInfo", new LoginInfoDTO());
		return "login-page";
	}
	
	@RequestMapping("/loginValidation")
	public String loginValidation(@Valid @ModelAttribute("loginInfo") LoginInfoDTO loginInfoDto, BindingResult result, HttpServletRequest request)
	{
		System.out.println("Inside Login Validation controller");
		System.out.println(loginInfoDto.isCheckbox());
		if(result.hasErrors())
		{
			System.out.println("Errors detected");
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError errors : allErrors)
			{
				System.out.println(errors);
			}
			return "login-page";
		}
		HttpSession session = request.getSession();
		String appResults = calcuResults.calulateResult(loginInfoDto.getYourName(), loginInfoDto.getEnemyName());
		session.setAttribute("appResult", appResults);
		return "loginValidation-page";
	}
	
}
