package com.ddpbank.lc.propertyEditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		System.out.println("Inside name property editor");
		String allCaps = text.toUpperCase();
		setValue(allCaps);
		
	}
	
}
