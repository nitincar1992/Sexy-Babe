package com.ddpbank.lc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ddpbank.lc.converter.AmountConverter;
import com.ddpbank.lc.converter.AmountStringConverter;
import com.ddpbank.lc.formatter.PhoneFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.ddpbank.lc"})
@PropertySource("classpath:email.properties")
public class LoveCalculatorApplicationConfig implements WebMvcConfigurer{

	@Autowired
	private Environment env;
	
	@Bean
	public InternalResourceViewResolver resolve() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		System.out.println("Inside formatter method");
		registry.addFormatter(new PhoneFormatter());
		registry.addConverter(new AmountConverter());
		registry.addConverter(new AmountStringConverter());
	}
	
	@Bean
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean validator()
	{
		LocalValidatorFactoryBean localValidator = new LocalValidatorFactoryBean();
		localValidator.setValidationMessageSource(messageSource());
		return localValidator;
	}
	
	@Override
	public Validator getValidator() {
		
		return validator();
		
	}
	
	@Bean
	public JavaMailSender getJavaMailSender()
	{
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port")));
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.debug", "true");
	    properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		javaMailSenderImpl.setJavaMailProperties(properties);
		return javaMailSenderImpl;
	}
	
}
