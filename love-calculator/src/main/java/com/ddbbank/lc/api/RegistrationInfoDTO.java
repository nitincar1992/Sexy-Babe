package com.ddbbank.lc.api;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.ddpbank.lc.Validator.Age;
import com.ddpbank.lc.Validator.Phone;

public class RegistrationInfoDTO {

	@NotEmpty(message = "{name.anynotEmpty}")
	private String name;
	private String username;
	private char[] password;
	private String country;
	private String[] hobby;
	private String gender;
	@Age(lower = 34, upper = 76)
	private Integer age;
	private Date date;
	private CreditCardDTO creditCard;
	private AmountDTO amount;
	private BigDecimal money;
	private Currency currencyFormat;
	@Phone
	private CommunicationDTO comDto;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CreditCardDTO getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardDTO creditCard) {
		this.creditCard = creditCard;
	}

	public AmountDTO getAmount() {
		return amount;
	}

	public void setAmount(AmountDTO amount) {
		this.amount = amount;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Currency getCurrencyFormat() {
		return currencyFormat;
	}

	public void setCurrencyFormat(Currency currencyFormat) {
		this.currencyFormat = currencyFormat;
	}

	public CommunicationDTO getComDto() {
		return comDto;
	}

	public void setComDto(CommunicationDTO comDto) {
		this.comDto = comDto;
	}

	@Override
	public String toString() {
		return "RegistrationInfoDTO [name=" + name + ", username=" + username + ", password="
				+ Arrays.toString(password) + ", country=" + country + ", hobby=" + Arrays.toString(hobby) + ", gender="
				+ gender + ", age=" + age + ", date=" + date + ", creditCard=" + creditCard + ", amount=" + amount
				+ ", money=" + money + ", currencyFormat=" + currencyFormat + ", comDto=" + comDto + "]";
	}
	
}
