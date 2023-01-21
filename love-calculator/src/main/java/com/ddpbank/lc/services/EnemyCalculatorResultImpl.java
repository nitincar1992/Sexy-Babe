package com.ddpbank.lc.services;

import org.springframework.stereotype.Service;

@Service
public class EnemyCalculatorResultImpl implements EnemyCalculatorResult {

	public static final String formula = "FLAMES";
	EnemyCalculatorDeclarations decl;

	@Override
	public String calulateResult(String yourName, String enemyName) {
		int lengthOfNames = (yourName + enemyName).toCharArray().length;
		int lengthOfFormula = formula.toCharArray().length;
		int rem = lengthOfNames % lengthOfFormula;
		char character = formula.charAt(rem);
		String relation = whatsBetweenUs(character);
		return relation;
	}

	@Override
	public String whatsBetweenUs(char character) {
		String word = "";
		if(character == 'F')
		{
			word = decl.F_MEANING;
		}
		else if(character == 'L')
		{
			word = decl.L_MEANING;
		}
		else if(character == 'A')
		{
			word = decl.A_MEANING;
		}
		else if(character == 'M')
		{
			word = decl.M_MEANING;
		}
		else if(character == 'E')
		{
			word = decl.E_MEANING;
		}
		else if(character == 'S')
		{
			word = decl.S_MEANING;
		}
		return word;
	}

}
