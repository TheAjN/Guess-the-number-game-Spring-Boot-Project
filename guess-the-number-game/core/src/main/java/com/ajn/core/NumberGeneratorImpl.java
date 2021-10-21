package com.ajn.core;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("numberGenerator")
public class NumberGeneratorImpl implements NumberGenerator{

	//== fields ==
	
	private final Random random = new Random();
	
	private final int maxNumber;
	private final int minNumber;
	
	// == constructors == 
	
	@Autowired
	public NumberGeneratorImpl(@MaxNumber int maxNumber,@MinNumber int minNumber) {
		super();
		this.maxNumber = maxNumber;
		this.minNumber = minNumber;
	}
	
	//== public methods ==
	
	@Override
	public int next() {
		// example : min = 5 , max = 20 --> max-min=15 --> range 0 to 15 + 5 = range 5 to 20
		return (random.nextInt(maxNumber - minNumber) + minNumber); //returns a random number at maximum value of 100
	}



	@Override
	public int getMaxNumber() {
		// TODO Auto-generated method stub
		return maxNumber;
	}

	@Override
	public int getMinNumber() {
		// TODO Auto-generated method stub
		return minNumber;
	}

	
}
