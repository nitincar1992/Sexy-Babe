package com.ddpbank.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/*
public class LoveCalculatorApplicationIntializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext annotationWebApplicationContext = new AnnotationConfigWebApplicationContext();
		annotationWebApplicationContext.register(LoveCalculatorApplicationConfig.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationWebApplicationContext);
		ServletRegistration.Dynamic customServlet = servletContext.addServlet("frontcontroller", dispatcherServlet);
		customServlet.setLoadOnStartup(1);
		customServlet.addMapping("/mywebsite.com/*");
		
	}

}
*/