package com.giftcard.dbconnectivitytestcases;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.giftcard.boundarytestcases.EntityValidationTest;

public class Test {				
	public static void main(String[] args) {									
		Result result = JUnitCore.runClasses(EntityValidationTest.class);					
	for (Failure failure : result.getFailures()) {							
 		System.out.println(failure.toString());					
}		
System.out.println(result.wasSuccessful());					
}		
}
