package org.usp.test01;

import javax.ejb.Stateless;
//import javax.ejb.Stateful;
import javax.ejb.Local;
import javax.ejb.Remote;

@Stateless // @Stateful
public class CalculatorImpl 
	implements CalculatorRemote, CalculatorLocal {

	public int sum(int add1, int add2) {
		return add1+add2;
	}

	public int multiply(int mul1, int mul2) {
		return mul1*mul2;
	}

}
