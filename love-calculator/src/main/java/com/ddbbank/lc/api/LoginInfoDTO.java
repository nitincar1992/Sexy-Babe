package com.ddbbank.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoginInfoDTO {

	@NotBlank(message = "* your name cannot be blank")
	@Size(min = 3, max = 15, message = "{userYourName}")
	private String yourName;
	@NotBlank(message = "* enemy name cannot be blank")
	@Size(min = 3, max = 15, message = "{userEnemyName}")
	private String enemyName;
	@AssertTrue(message = "First agree it")
	private boolean checkbox;	

	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getEnemyName() {
		return enemyName;
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}

	public boolean isCheckbox() {
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	@Override
	public String toString() {
		return "LoginInfoDTO [yourName=" + yourName + ", enemyName=" + enemyName + ", checkbox=" + checkbox + "]";
	}

}
