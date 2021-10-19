package com.ajn.core;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("numberGenerator")
public class NumberGeneratorImpl implements NumberGenerator{

	//== fields ==
	private final Random random = new Random();
	
	@Autowired
	@MaxNumber
	private int maxNumber;
	
	
	//== public methods ==
	@Override
	public int next() {
		// TODO Auto-generated method stub
		return random.nextInt(maxNumber); //returns a random number at maximum value of 100
	}

	@Override
	public int getMaxNumber() {
		// TODO Auto-generated method stub
		return maxNumber;
	}

	
}
